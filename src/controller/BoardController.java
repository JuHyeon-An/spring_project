package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.BoardMybatisDao;
import bean.Page;
import mybatis.AttVo;
import mybatis.BoardVo;
import mybatis.FileUpload;

@Controller
public class BoardController {
	BoardMybatisDao dao;
	
	BoardController(BoardMybatisDao dao){
		this.dao = dao;
	}
	
	
	ModelAndView mv;
	@RequestMapping(value = "/select.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select(HttpServletRequest req) {
		mv = new ModelAndView();
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		int nowPage = 1;
		if(req.getParameter("nowPage")!=null && req.getParameter("nowPage")!="") {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}
		p.setNowPage(nowPage);
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("p", p);
		mv.addObject("list", list);
		//데이터를 심을때
		// 이렇게 담으면 request영역에 담겨져서 나감
		// ${list} 로 받을 수 있다는 의!미!
		
		mv.setViewName("select");
		// select라는 페이지에 넘기겠다!
		// 그럼 얘가 resolver에서 받음 
		return mv;
	}
	
	@RequestMapping( value ="/view.brd", method= {RequestMethod.POST})
	public ModelAndView view(HttpServletRequest req) {
		mv = new ModelAndView();
		BoardVo vo = null;
		List<AttVo> attList = null;
		int serial = Integer.parseInt(req.getParameter("serial"));
		String v = "v";
		vo = dao.view(serial, v);
		attList = dao.getAttList(serial);
		
		// 중복되는 부분 메소드로 따로 분기해도 됨
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		int nowPage = 1;
		if(req.getParameter("nowPage")!=null && req.getParameter("nowPage")!="") {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}
		p.setNowPage(nowPage);
		
		mv.addObject("attList", attList);
		mv.addObject("p", p);
		mv.addObject("vo", vo);
		mv.setViewName("view");
		
		return mv;
	}
	
	@RequestMapping( value = "insert.brd", method = {RequestMethod.POST})
	public ModelAndView insert() {
		mv = new ModelAndView();
		mv.setViewName("insert");
		return mv;
	}

	@RequestMapping( value = "insertR.brd", method = {RequestMethod.POST})
	public ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
		mv = new ModelAndView();
		String msg = "";
		
		FileUpload fu = new FileUpload(req, resp);
		HttpServletRequest newReq = fu.uploading();
		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
		List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
		
		msg = dao.insert(vo, attList);
		
		System.out.println(newReq.getAttribute("p"));
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "modify.brd", method = {RequestMethod.POST})
	public ModelAndView modify(HttpServletRequest req) {
		mv = new ModelAndView();
		int serial = Integer.parseInt(req.getParameter("serial"));
		BoardVo vo = dao.view(serial, "");
		List<AttVo> attList = dao.getAttList(serial);
		
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		
		mv.addObject("p", p);
		mv.addObject("vo", vo);
		mv.addObject("attList", attList);
		mv.setViewName("modify");
		return mv;
	}
	
	@RequestMapping( value = "modifyR.brd", method = {RequestMethod.POST})
	public ModelAndView modifyR(HttpServletRequest req, HttpServletResponse resp) {
		mv = new ModelAndView();
		
		FileUpload fu = new FileUpload(req, resp);
		HttpServletRequest newReq = fu.uploading();
		
		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
		List<AttVo> att = (List<AttVo>)newReq.getAttribute("attList");
		List<AttVo> del = (List<AttVo>)newReq.getAttribute("delList");
		
		String msg = dao.modify(vo, att, del);

		mv.addObject("msg", msg);
		mv.addObject("p", req.getAttribute("p"));
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "deleteR.brd", method = {RequestMethod.POST})
	public ModelAndView deleteR(HttpServletRequest req) {
		mv = new ModelAndView();
		BoardVo vo = new BoardVo();
		int serial = Integer.parseInt(req.getParameter("serial"));
		String pwd = req.getParameter("pwd");

		Page p = new Page();
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		p.setFindStr(req.getParameter("findStr"));
		
		vo.setSerial(serial);
		vo.setPwd(pwd);
		String msg = dao.delete(vo);
		
		mv.addObject("p", p);
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "repl.brd", method = {RequestMethod.POST})
	public ModelAndView repl() {
		mv = new ModelAndView();
		mv.setViewName("repl");
		return mv;
	}
	
	@RequestMapping( value = "replR.brd", method = {RequestMethod.POST})
	public ModelAndView replR(HttpServletRequest req, HttpServletResponse resp) {
		
		mv = new ModelAndView();
		String msg = "";
		
		FileUpload fu = new FileUpload(req, resp);
		HttpServletRequest newReq = fu.uploading();
		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
		List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
		
		msg = dao.repl(vo, attList);
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
}
