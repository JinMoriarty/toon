package com.toon.controller;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.toon.domain.CategoryVO;
import com.toon.domain.MemberVO;
import com.toon.domain.ToonVO;
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
		
	// 상품 조회
		@RequestMapping(value = "/toons/view", method = RequestMethod.GET)
		public void getToonsview(@RequestParam("n") int toonNum, Model model) throws Exception {
		 logger.info("get toons view");
		 
		 ToonVO toons = adminService.toonsView(toonNum);
		 
		 model.addAttribute("toons", toons);		
		 }
		
	
}

