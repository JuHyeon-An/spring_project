package mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Page;
import bean.MemberVo;
import bean.MemberPhoto;

public class MemberUpload {
	// 파일 업로드하는 고유한 기능 갖도록
	
//	String upload = "c:/Users/JHTA/git/web1/1907-web/WebContent/upload/";
	static public String upload = "c:/Users/Ellen/eclipse-workspace/1907-spring/WebContent/member_photo/";
	// 업로드되는 경로명
	String tempDir = "c:/temp/";
	// 파일이 전송되는 중간 중간 저장되는 장소
	
	int maxSize = 1024*1024*50; // 파일이 업로드 되는 최대 사이즈 (최대크기 50메가)
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public MemberUpload(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	public boolean uploadFormCheck() {
		boolean flag = ServletFileUpload.isMultipartContent(req);
		// 업로드되는 폼이 정확하지 않으면 false 리턴
		// 결과값이 true일때 uploading이라는 메소드를 호출
		return flag;
	}
	
	public HttpServletRequest uploading() {
		//request 영역에 vo, attList, delList, page까지 모두 담아야해서 request형태로 반환
		MemberVo vo = new MemberVo();
		List<MemberPhoto> attList = new ArrayList<MemberPhoto>();
		// 첨부파일 목록
		Page p = new Page();
		// 폼태그가 enctype일 때 findStr, nowPage는 받을 수 없다.
			
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 아파치에서 파일을 업로드하기 위한 가장 기본적인 코드 (factory)
		factory.setSizeThreshold(4096);
		// 파일 업로드 환경 설정
		// 파일 업로드할때 사용하는 메모리의 크기 (버퍼 약 4k)
		// 50메가 중 4k씩 저장되는 것 (임시저장소에)
		
		factory.setRepository(new File(tempDir));
		// 파일이 업로드되면서 임시로 저장되는 공간 (temp)
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		// 실제로 파일 업로드하기 위한 클래스
		
		sf.setHeaderEncoding("utf-8"); // utf8로 인코딩
		sf.setFileSizeMax(maxSize);
		// 여기까지 고정된 코드
		
		String mId = "";
		try {
			List<FileItem> list = sf.parseRequest(req);
			// form 태그에 들어가있는 input 태그들 parsing해서 처리한것이 list
			for(FileItem fi : list) {
				// list에 들어가있는 하나하나의 값을 파일아이템에
				String v = fi.getString("utf-8");
				// input 상자에 들어가있는 문자열(value값)이 한글인 경우에 utf-8로 인코딩을 해서 v에 넣기
				String k = fi.getFieldName();
				// input 태그의 name값 : getFieldName
				
				// v 는  value, k는 name
				
				/* 폼태그에 들어가있는 인풋 태그를 모두 파싱해서 리스트에 넣고, 하나하나 꺼내서
				 * value값과 name값을 각각 v와  k에 담는다 
				 */
				if(fi.isFormField()) {
					// input타입이 파일이 아닌가? => else(파일인경우)
					switch (k) { // name값을 가져와서
					case "mId": //<input type="text" name="mId"/>
					// input 상자의 name값이 mId면 v값을 vo의 mId에 집어넣어라
						vo.setmId(v);
						break;
						
					case "pwd":
						vo.setPwd(v);
						break;
						
					case "mName":
						vo.setmName(v);
						break;
						
					case "rDate":
						vo.setrDate(v);
						break;
						
					case "grade":
						if(v!=null && v!="") {
							vo.setGrade(Integer.parseInt(v));
						}
						break;
						
					case "findStr":
						// 폼태그 이름이 findStr이면 value값을 attribute에 저장
						p.setFindStr(v);
						break;
						
					case "nowPage":
						if(v!=null && v!="") {
							p.setNowPage(Integer.parseInt(v));
						}
						break;
					
					default:
						break;
					}
				}else { // <input type='file'/>인 경우
					if(fi.getSize()>0) {
						// file 태그가 여러개가 있다면 n번 돌게 될 것
						
						// file사이즈가 0이라면 파일이 넘어오지 않은 것
						// 파일을 선택하지 않고 등록버튼을 누른 경우 파일사이즈가 0
						
						String f = fi.getName();
						// file name을 가지고 오는 작업
						System.out.println("파일 이름 : "+f);
						
						String sysFile = new Date().getTime() +"-"+f;
						// file명에 현재시간을 롱타입으로 바꿔서 집어넣어서 시스템파일명을 만들었다
						System.out.println("sysFile : "+sysFile);
						
						MemberPhoto attVo = new MemberPhoto();
						attVo.setOriFile(f);
						// getName에 의해서 만들어진 오리지널 파일
						attVo.setSysFile(sysFile);
						// 임의로 만든 시스템파일
						attList.add(attVo);
						vo.setPhotos(attList);
						File file = new File(upload + sysFile);
						// upload 경로 안에 sysFile 더해서 만들고 : upload라는 path에 저장됨
						fi.write(file);
						// file을 실제로 저장
						
						fi.delete();
						// temp에 들어가있는 임시 파일을 지우는 작업
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("vo", vo);
		req.setAttribute("p", p);
		
		return req;
	}
}
