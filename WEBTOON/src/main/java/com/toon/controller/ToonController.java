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
import org.springframework.web.bind.annotation.ResponseBody;

import com.toon.domain.MarkListVO;
import com.toon.domain.MarkVO;
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
		
		int toonView = 0;
		
		service.addView(toonNum);
		
		model.addAttribute("addView",toonView);
		
		ToonsViewVO view = service.toonsView(toonNum);
		 model.addAttribute("view", view);
		 
		 System.out.println("조회수 : "+toonView);
		 
		 /*List<ReplyListVO> reply = service.replyList(toonNum);
		 model.addAttribute("reply", reply);*/
	}
	
	/*
	// 작품 조회 - 댓글 작성
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String registReply(ReplyVO reply, HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 reply.setUserId(member.getUserId());
	 
	 service.registReply(reply);
	 
	 return "redirect:/toon/view?n=" + reply.getToonNum();
	}
	*/
	
	// 작품 댓글 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply, HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 reply.setUserId(member.getUserId());
	 
	 service.registReply(reply);
	} 
	
	// 작품 댓글 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int toonNum) throws Exception {
		logger.info("get reply list");
		System.out.println(toonNum);
		List<ReplyListVO> reply = service.replyList(toonNum);
			
		return reply;
	}
	
	
	// 작품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply,  HttpSession session) throws Exception {
		logger.info("post delete reply");
			// 정상작동 여부를 확인하기 위한 변수
		int result = 0;
			
		MemberVO member = (MemberVO)session.getAttribute("member");  // 현재 로그인한  member 세션을 가져옴
		String userId = service.idCheck(reply.getRepNum());  // 소감(댓글)을 작성한 사용자의 아이디를 가져옴
				
		// 로그인한 아이디와, 소감을 작성한 아이디를 비교
		if(member.getUserId().equals(userId)) {
			
			// 로그인한 아이디가 작성한 아이디와 같다면
			
		reply.setUserId(member.getUserId());  // reply에 userId 저장
			service.deleteReply(reply);  // 서비스의 deleteReply 메서드 실행
				
			// 결과값 변경
			result = 1;
		}
			
		// 정상적으로 실행되면 소감 삭제가 진행되고, result값은 1이지만
		// 비정상적으로 실행되면 소감 삭제가 안되고, result값이 0
		System.out.println(result);
		return result;	
		}
		
	// 작품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("modify reply");
			
		int result = 0;
			
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
			
		if(member.getUserId().equals(userId)) {
				
			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}
			
		return result;
			
	}	
	
	// 책갈피
	@ResponseBody
	@RequestMapping(value = "/view/addMark", method = RequestMethod.POST)
	public int addMark(MarkListVO mark, HttpSession session) throws Exception {
			
		int result = 0;
			
		MemberVO member = (MemberVO)session.getAttribute("member");
			
		if(member != null) {
			mark.setUserId(member.getUserId());
			service.addMark(mark);
			result = 1;
		}
		
		return result;
	}
			
	// 책갈피 목록
	@RequestMapping(value = "/markList", method = RequestMethod.GET)
	public void getMarkList(HttpSession session, Model model) throws Exception {
		logger.info("get cart list");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
		
		List<MarkListVO> markList = service.markList(userId);
		
		model.addAttribute("markList", markList);
	}
	
	
	// 책갈피 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteMark", method = RequestMethod.POST)
	public int deleteMark(HttpSession session,
	     @RequestParam(value = "chbox[]") List<String> chArr, MarkVO mark) throws Exception {
	 logger.info("delete mark");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 String userId = member.getUserId();
	 
	 int result = 0;
	 int markNum = 0;
	 
	 
	 if(member != null) {
	  mark.setUserId(userId);
	  
	  for(String i : chArr) {   
	   markNum = Integer.parseInt(i);
	   mark.setMarkNum(markNum);
	   service.deleteMark(mark);
	  }   
	  result = 1;
	 }  
	 return result;  
	}	
	
	//게시물 추천 관련 메소드
    @RequestMapping("/toon/addGood")
    public String addGood (@RequestParam int toonNum) throws Exception {
        
        service.addGood(toonNum);
    
        return "forward:/toon/view"; //페이지값을 그대로 넘겨받기위해서 포워딩을 사용해 컨트롤러로 리턴시킨다.
    }
    

	
}