package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.MemberDao;
import bean.MemberVo;
import bean.Page;
import mybatis.MemberUpload;

@Controller
public class MemberController {
	
	MemberDao dao;
	
	MemberController(MemberDao dao){
		this.dao = dao;
	}

	ModelAndView mv;
	@RequestMapping(value = "/select.mm", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select(HttpServletRequest req, HttpServletResponse resp) {
		mv = new ModelAndView();
		
		Page p = new Page();
		
		String findStr = "";
		int nowPage = 1;
		if(req.getParameter("findStr")!=null) {
			p.setFindStr(req.getParameter("findStr"));
		}
		if(req.getParameter("nowPage")!=null) {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		List<MemberVo> list = dao.select(p);

		mv.addObject("list", list);
		//데이터를 심을때
		// 이렇게 담으면 request영역에 담겨져서 나감
		// ${list} 로 받을 수 있다는 의!미!
		
		mv.setViewName("select");
		// select라는 페이지에 넘기겠다!
		// 그럼 얘가 resolver에서 받음 
		return mv;
	}
	
	@RequestMapping( value ="/view.mm", method= {RequestMethod.POST})
	public ModelAndView view() {
		mv = new ModelAndView();
		mv.setViewName("view");
		
		return mv;
	}
	
	@RequestMapping( value = "/insert.mm", method = {RequestMethod.POST})
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse resp) {
		mv = new ModelAndView();
		mv.setViewName("insert");
		return mv;
	}

	@RequestMapping( value = "insertR.mm", method = {RequestMethod.POST})
	public ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
		mv = new ModelAndView();
		String msg = "회원 정보가 저장되었습니다.";
		
		MemberUpload mu = new MemberUpload(req, resp);
		HttpServletRequest newReq = mu.uploading();
		
		MemberVo vo = (MemberVo)newReq.getAttribute("vo");
		Page p = (Page)newReq.getAttribute("p");

		System.out.println(vo.getmId());
		System.out.println(vo.getPhotos().get(0));
		System.out.println(vo.getmName());
		System.out.println(vo.getGrade());
		System.out.println(vo.getPwd());
		
		msg = dao.insert(vo);
		mv.addObject("vo", vo);
		mv.addObject("msg", msg);
		mv.addObject("p", p);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "modify.mm", method = {RequestMethod.POST})
	public ModelAndView modify() {
		mv = new ModelAndView();
		mv.setViewName("modify");
		return mv;
	}
	
	@RequestMapping( value = "modifyR.mm", method = {RequestMethod.POST})
	public ModelAndView modifyR() {
		String msg = "수정이 완료되었습니다.";
		mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "deleteR.mm", method = {RequestMethod.POST})
	public ModelAndView deleteR() {
		String msg = "삭제가 완료되었습니다.";
		mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "repl.mm", method = {RequestMethod.POST})
	public ModelAndView repl() {
		mv = new ModelAndView();
		mv.setViewName("repl");
		return mv;
	}
	
	@RequestMapping( value = "replR.mm", method = {RequestMethod.POST})
	public ModelAndView replR() {
		String msg = "등록이 완료되었습니다.";
		mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "login.mm", method = {RequestMethod.POST})
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		boolean result;
		MemberVo vo = new MemberVo();
		vo.setmId(req.getParameter("mId"));
		vo.setPwd(req.getParameter("pwd"));
		
		result = dao.login(vo);
		String msg = "";
		if(!result) {
			msg = "아이디나 비밀번호가 틀렸습니다.";
		}else {
			msg = "로그인 성공";
			session.setAttribute("mId", vo.getmId());
		}
		mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "logout.mm", method = {RequestMethod.GET})
	public ModelAndView logout(HttpSession session) {
		System.out.println("로그아웃 ㅡㅡ");
		session.invalidate();
		mv = new ModelAndView();
		mv.setViewName("logout");
		return mv;
	}
	
}
