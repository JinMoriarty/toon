package com.toon.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;
import com.toon.domain.ToonsViewVO;
import com.toon.service.AdminService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	// 관리자화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index"); 
	}
	
	// 카테고리
	@RequestMapping(value = "/toons/register", method = RequestMethod.GET)
	public void getToonsRegister(Model model) throws Exception {
	 logger.info("get toons register");
	 
	 List<CategoryVO> category = null;
	 category = adminService.category();
	 model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 작품 등록
	@RequestMapping(value = "/toons/register")
	public String postToonRegister(ToonVO vo) throws Exception {
		logger.info("post toon register");
		
		
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}		
	
	// 작품 목록
		@RequestMapping(value = "/toons/list", method = RequestMethod.GET)
		public void getToonsList(Model model) throws Exception {
			logger.info("get toons list");
			
			List<ToonVO> list = adminService.toonslist();
			
			model.addAttribute("list",list);			
		}

	 // 작품 조회
		@RequestMapping(value = "/toons/view", method = RequestMethod.GET)
		public void getToonsview(@RequestParam("n") int toonNum, Model model) throws Exception {
		 logger.info("get toons view");
		 
		 ToonsViewVO toons = adminService.toonsView(toonNum);
		 
		 model.addAttribute("toons", toons);		
		 }
		
	// 작품 수정 
		@RequestMapping(value = "/toons/modify", method = RequestMethod.GET)
		public void getToonsModify(@RequestParam("n") int toonNum, Model model) throws Exception {
		// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 toonNum에 저장
			
			logger.info("get toons modify");
			
			ToonsViewVO toons = adminService.toonsView(toonNum);  // ToonsViewVO형태 변수 toons에 상품 정보 저장
			model.addAttribute("toons", toons);
			
			
			List<CategoryVO> category = null;
			category = adminService.category();
			model.addAttribute("category", JSONArray.fromObject(category));
		}
		
	// 상품 수정
		@RequestMapping(value = "/toons/modify", method = RequestMethod.POST)
		public String postToonsModify(ToonVO vo) throws Exception {
		 logger.info("post toons modify");

		 adminService.toonsModify(vo);
		 
		 return "redirect:/admin/index";
		}
		
	// 상품 삭제
		@RequestMapping(value = "/toons/delete", method = RequestMethod.POST)
		public String postToonsDelete(@RequestParam("n") int toonNum) throws Exception {
		// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 toonNum에 저장
		
			logger.info("post toons delete");
		
			adminService.toonsDelete(toonNum);
			
			return "redirect:/admin/index";
		}
}

