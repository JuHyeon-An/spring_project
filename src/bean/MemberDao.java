package bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.MemberPhoto;
import bean.MemberVo;
import mybatis.AttVo;
import mybatis.Factory;
import mybatis.FileUpload;

public class MemberDao {
// 서블릿과 BoardMybatis를 연결해주는 역할

	SqlSession sqlSession;
	// 가장 중요한 역할!
	String msg = "";
	int cnt = 0;
	
	public MemberDao() {
		sqlSession = Factory.getFactory().openSession();
		//mybatis와 연결되어지는 연결고리
	}
	
	public boolean login(MemberVo vo) {
		boolean a = true;
		try {
			cnt = sqlSession.selectOne("member.login", vo);
			if(cnt<1) a = false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return a;
		}
	}
	
	public List<MemberVo> select(Page p) {
		List<MemberVo> list = null;
		try {
			cnt = sqlSession.selectOne("member.count", p);
			p.setTotListSize(cnt);
			p.pageCompute();
			
			list = sqlSession.selectList("member.select", p);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return list;
		}
	}
	
	public String insert(MemberVo vo) {
		try {
			cnt = sqlSession.insert("member.insert", vo);
			System.out.println("cnt1 : "+cnt);
			
			if(cnt>0) sqlSession.commit();
			
			List<MemberPhoto> photos = vo.getPhotos();
			
			for(MemberPhoto mp : photos) {
				System.out.println(mp.sysFile);
				mp.setmId(vo.getmId());
				cnt = sqlSession.insert("member.attInsert", mp);
				if(cnt>0) sqlSession.commit();
			}
			
			System.out.println("cnt2 : "+cnt);
		}catch(Exception ex) {
			ex.printStackTrace();
			sqlSession.rollback();
		}finally {
			return msg; 
		}
	}
	
	public MemberVo view(String mId) {
			MemberVo vo = null;
		try {
			vo = sqlSession.selectOne("member.view", mId);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return vo;
		}
	}
	
	public String delete(String mId) {
		String msg = "성공적으로 삭제가 되었네요?!";
		try {
			cnt = sqlSession.delete("member.delete", mId);
			if(cnt>0) {
				sqlSession.commit();	
			}else {
				throw new Exception("본문 삭제 중 오류가 발생했다!");
			}
			
			MemberPhoto mp = sqlSession.selectOne("member.selectAtt", mId);
			
			cnt = sqlSession.delete("member.deleteAtt", mId);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				throw new Exception("사진 삭제 중 오류가 발생했다!");
			}

			if(mp!=null) {
				delFile(mp);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return msg;
		}
	}
	
	public void delFile(MemberPhoto mp) {
			File f = new File(FileUpload.upload + mp.getSysFile());
			if(f.exists()) f.delete();
		}
	}
	
