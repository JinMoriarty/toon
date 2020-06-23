package com.toon.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.toon.domain.MemberVO;
import com.toon.domain.ReplyListVO;
import com.toon.domain.ReplyVO;
import com.toon.domain.ToonsViewVO;
import com.toon.service.ToonService;

@Controller
@RequestMapping("/toon/*")
public class ToonController {

	private static final Logger logger = LoggerFactory.getLogger(ToonController.class);

	@Inject
	ToonService service;

	// 카테고리별 상품 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get llist");

		List<ToonsViewVO> list = null;
		list = service.list(cateCode, level);

		model.addAttribute("list", list);
	}
	
	// 작품 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n")int toonNum, Model model) throws Exception{
		logger.info("get view");
		
		ToonsViewVO view = service.toonsView(toonNum);
		 model.addAttribute("view", view);
		 
		 List<ReplyListVO> reply = service.replyList(toonNum);
		 model.addAttribute("reply", reply);
	}
	
	// 작품 조회 - 댓글 작성
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String registReply(ReplyVO reply, HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 reply.setUserId(member.getUserId());
	 
	 service.registReply(reply);
	 
	 return "redirect:/toon/view?n=" + reply.getToonNum();
	}
	
	
	
}