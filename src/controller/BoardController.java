package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@RequestMapping(value = "/select.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
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
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo", vo);
		mv.setViewName("view");
		
		return mv;
	}
}
