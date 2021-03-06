package bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.AttVo;
import mybatis.BoardVo;
import mybatis.Factory;
import mybatis.FileUpload;

public class BoardMybatisDao {
// 서블릿과 BoardMybatis를 연결해주는 역할

	SqlSession sqlSession;
	// 가장 중요한 역할!
	
	public BoardMybatisDao() {
		sqlSession = Factory.getFactory().openSession();
		//mybatis와 연결되어지는 연결고리
	}
	
	public List<BoardVo> select(Page p) {
		// 여기에 nowPage & findStr이 넘어와야함
		List<BoardVo> list = null;
		
		try {
			int totList = sqlSession.selectOne("board.count", p);
			p.setTotListSize(totList);
			p.pageCompute();
			System.out.println(totList);
			/*System.out.println("마지막 페이지 : "+p.endPage);
			System.out.println("endNo : " +p.endNo);
			System.out.println("totPage : "+p.totPage);*/
			// 나머지 변수의 값이 설정됨
			list = sqlSession.selectList("board.select", p);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			// 오픈한 sqlSession을 반드시 close
			//sqlSession.close();
			return list;
		}
	}
	
	public String insert(BoardVo vo, List<AttVo> attList) {
		String msg = "정상적으로 저장되었습니다.";
		System.out.println("insert가 실행이 되긴 하나요....");
		try {
			System.out.println("try를 하긴 하나요....");
			int cnt = sqlSession.insert("board.insert", vo);
			System.out.println("본문 저장 : "+cnt);
			if(cnt<1) {
				throw new Exception("본문 저장 중 오류발생");
			}
			
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.att_insert", attVo);
				System.out.println("첨부파일 저장 : "+cnt);
				if(cnt<1) {
					throw new Exception("첨부 파일 저장 중 오류발생");
				}
			}
				
			sqlSession.commit();
		}catch(Exception ex){
			msg = ex.getMessage();
			ex.printStackTrace();
			
			sqlSession.rollback();
			delFile(attList);
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	//insert, modify에서 sql 오류가 발생할 때, 삭제할 때 공통으로 사용하는 메소드
	public void delFile(List<AttVo> delList) {
		for(AttVo attVo : delList) {
			File f = new File(FileUpload.upload + attVo.getSysFile());
			if(f.exists()) f.delete();
		}
	}
	
	//상세보기, 수정
	public BoardVo view(int serial, String flag) {
		BoardVo vo = null;
		int cnt = 0;
		try {
			if(flag!="") { //flag값이 있으면 조회수 증가
				cnt = sqlSession.update("board.hit_up", serial);
				if(cnt>0) sqlSession.commit();
			}
			
			vo = sqlSession.selectOne("board.view", serial);
		}catch(Exception ex) {
			ex.printStackTrace();
			//sqlSession.rollback();
		}finally {
			// 사진첨부에서 또 session을 불러와야하므로 close 시키면 안됨
			return vo;
		}
	}
	
	public List<AttVo> getAttList(int pserial){
		List<AttVo> list = null;
		try {
			list = sqlSession.selectList("board.att_list", pserial);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//sqlSession.close();
			return list;
		}
	}
	
	public String modify(BoardVo vo, List<AttVo> attList, List<AttVo> delList) {
		String msg = "정상적으로 수정되었습니다.";
		try {
			// 본문 글 수정
			int cnt = sqlSession.update("board.update", vo);
			if(cnt<1) {
				throw new Exception("본문 수정 중 오류가 발생했습니다.");
			}
			
			// boardAtt에 첨부 파일 정보를 추가
			for(AttVo attVo : attList) {
				attVo.setSerial(vo.getSerial());
				cnt = sqlSession.insert("board.att_insert2", attVo);
				if(cnt<1) throw new Exception("첨부 데이터 정보 수정 중 오류 발생");
			}
			
			System.out.println(delList+"delList가 있나요");
			
			// boardAtt에 삭제파일 정보를 제거
			for(AttVo attVo : delList) {
				cnt = sqlSession.delete("board.att_delete", attVo);
				if(cnt<1) throw new Exception("파일 삭제 중 오류 발생");
			}
			
			// 파일을 삭제
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception ex) {
			delFile(attList);
			ex.printStackTrace();
			msg = ex.getMessage();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	public String delete(BoardVo vo) {
		String msg = "정상적으로 삭제되었습니다.";
		int cnt = 0;
		try {
			// 삭제하기 전 댓글 존재 파악
			// 내 시리얼이 어떤 데이터의 pserial이면 exception
			cnt = sqlSession.selectOne("board.repl_cnt", vo.getSerial());
			if(cnt>0) throw new Exception("댓글이 있는 자료는 삭제할 수 없습니다.");
			
			// 본문 삭제
			/*System.out.println("시리얼 "+vo.getSerial());
			System.out.println("비밀번호 "+vo.getPwd());*/
			cnt = sqlSession.delete("board.delete", vo);
			if(cnt<1) {
				throw new Exception("본문 삭제 중 오류가 발생했습니다.");
			}

			// 첨부된 파일 목록
			List<AttVo> delList = sqlSession.selectList("board.att_list", vo.getSerial());
			System.out.println(vo.getSerial());
			System.out.println("여기 비었나" + delList);
			
			// 첨부 테이블 자료 삭제
			if(delList.size()>0) {
				cnt = sqlSession.delete("board.att_delete2", vo.getSerial());
				if(cnt<1) throw new Exception("사진 삭제 중 오류가 발생했습니다.");
			}
			
			// 실제 사진 파일 삭제
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception ex) {
			msg = ex.getMessage();
			ex.printStackTrace();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	public String repl(BoardVo vo, List<AttVo> attList) {
		String msg = "답글이 등록되었습니다.";
		int cnt = 0;
		try {
			// 댓글 저장
			cnt = sqlSession.insert("board.repl", vo);
			if(cnt<1) throw new Exception("댓글 저장 중 오류 발생");
			
			// 첨부 데이터 저장
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.att_insert", attVo);
				if(cnt<1) throw new Exception("첨부 데이터 저장 중 오류 발생");
			}
			
			sqlSession.commit();
		}catch(Exception ex) {
			delFile(attList);
			sqlSession.rollback();
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	public boolean login(MemberVo vo) {
		boolean a = true;
		int cnt = 0;
		try {
			
			cnt = sqlSession.selectOne("board.login", vo);
			if(cnt<1) throw new Exception("아이디나 비밀번호가 일치하지 않습니다");
		}catch(Exception ex) {
			
		}finally {
			//sqlSession.close();
			return a;
		}
		
	}
}
