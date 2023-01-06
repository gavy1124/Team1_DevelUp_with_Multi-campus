package com.multi.ongo.history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DealHistoryController {
	
	// 나의온고 click 시 보이는 화면
		@RequestMapping("/history/myongo")	// spring-config의 component-scan에 등록한 패키지 명 뒷부분 이어서 작성해야함 
		public ModelAndView myongopage () {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("history/myongo");
			return mav;
		}
		
	
	// 중고거래내역 list 
	@RequestMapping("/history/historylist")
	public ModelAndView historylist () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("history/historylist");
		return mav;
	}
	
	//중고내역 상세페이지
	@RequestMapping("/history/joongodetail")
	public ModelAndView joongodetail () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("history/joonggo_detail");
		return mav;
	}
	
}