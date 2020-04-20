package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.Page;

@Controller
public class BoardController {

	ModelAndView mv;
	@RequestMapping(value = "/select.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select() {
		mv = new ModelAndView();
		List<Object> list = new ArrayList<Object>();
		list.add("참 잘했어여~~~(board)");

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
	public ModelAndView view() {
		mv = new ModelAndView();
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
	public ModelAndView insertR() {
		mv = new ModelAndView();
		String msg = "게시판 정보가 저장되었습니다.";
		Page p = new Page();
		// dao를 쓰면 여기에 fileUpload 작업
		
		mv.addObject("msg", msg);
		mv.addObject("p", p);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "modify.brd", method = {RequestMethod.POST})
	public ModelAndView modify() {
		mv = new ModelAndView();
		mv.setViewName("modify");
		return mv;
	}
	
	@RequestMapping( value = "modifyR.brd", method = {RequestMethod.POST})
	public ModelAndView modifyR() {
		String msg = "수정이 완료되었습니다.";
		mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping( value = "deleteR.brd", method = {RequestMethod.POST})
	public ModelAndView deleteR() {
		String msg = "삭제가 완료되었습니다.";
		mv = new ModelAndView();
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
	public ModelAndView replR() {
		String msg = "등록이 완료되었습니다.";
		mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
}
