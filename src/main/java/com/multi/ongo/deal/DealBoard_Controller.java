package com.multi.ongo.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DealBoard_Controller {

	DealBoard_Service service;
	
	@Autowired
	public DealBoard_Controller(DealBoard_Service service) {
		super();
		this.service = service;
	}

	@RequestMapping("dealmain") //테스트
	public String dealPage() {
		return "deal_Register";
		
	}
	
	//중고거래 등록페이지 config-view처리 
	
	
	// 중고거래 게시글등록
	@RequestMapping("deal_Write.do")
	public String dealWrite(DealBoard_DTO dto) {
		service.writeProd(dto);
		return "redirect:/deal_listAll2.do?dealType=all";
				
		
	}
	
	
	//중고거래게시글 타입별조회(카테고리)
	@RequestMapping("deal_listAll2.do")
	public ModelAndView dealType_list(String dealType) {
		ModelAndView mav = new ModelAndView("deallistAll2");
		List<DealBoard_DTO> listall = service.dealType_list(dealType);
		mav.addObject("dealType",dealType);
		mav.addObject("listall",listall);
		return mav;
	}
	
	
	//중고거래게시글 전체리스트
//	@RequestMapping("deal_listAll.do")
//	public ModelAndView listall() {
//		ModelAndView mav = new ModelAndView("deallistAll");
//		List<DealBoard_DTO> listall = service.boardlist();
//		//System.out.println("listall 찍기체크1 : " + listall);
//		mav.addObject("listall",listall);
//		//System.out.println("listall 찍기체크2 : " + listall);
//		return mav;
//	}
	
	
	
	
	//중고거래게시글 읽기
	@RequestMapping("dealRead.do")
	public ModelAndView dealRead(int deal_number, String state) {
		DealBoard_DTO dealRead = service.dealRead(deal_number);
		String view = "";
		if(state.equals("READ")) {	
			System.out.println("조회수 처리전 : "+dealRead.getHits()+ "/______/매개변수확인" + deal_number);
			service.hits_update(deal_number);//조회
			System.out.println("조회수 처리후 : "+dealRead.getHits()  + "/______/매개변수확인" + deal_number);
			view ="dealBoardRead";
		}else {
			System.out.println("컨트롤 업데이트 진입 : " + deal_number); //넘어감
			view ="dealBoardUpdate";
		}
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("dealRead",dealRead);
		System.out.println("컨트롤 공유 dealread 체크:" + dealRead);
		//System.out.println("찍먹state:" + state);
		return mav;
	}
	
	//중고거래 게시글 수정
	@RequestMapping("dealUpdate.do")
	public String update(DealBoard_DTO dto) {
		//System.out.println("넘어오는가?찍먹1: " + dto);
		//System.out.println("getDeal_number넘어오는가?찍먹1: " + dto.getDeal_number());
		service.update(dto);
		//System.out.println("넘어오는가?찍먹2: " + dto);
		return "redirect:/deal_listAll2.do?dealType=all";
	}
	
	
	
	//중고거래 게시글 삭제
	@RequestMapping("dealDelete.do")
	public String dealDelete(int deal_number) {
		service.dealDelete(deal_number);
		return "redirect:/deal_listAll2.do?dealType=all";
	}
	
	//하단검색
	@RequestMapping("serarchData.do")
	public ModelAndView dataSearch(String tag, String searchData) {
		System.out.println("tag : " + tag + ",   searchData값 : " +  searchData);
		ModelAndView mav = new ModelAndView("deallistAll");
		List<DealBoard_DTO> listall = service.searchData(tag, searchData);
		mav.addObject("listall", listall);
		return mav;
	}

	
	//중고거래시글 타입-메인 [ajax]
	@RequestMapping(value = "/dealType_main.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<DealBoard_DTO> dealType_main(String dealType){
		System.out.println("ajax인입 매개변수 체크 : " + dealType);
		List<DealBoard_DTO> ajaxlist = service.dealType_main(dealType);
		System.out.println("ajax 통신 체크 : " + ajaxlist);
		return ajaxlist;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}



