package com.toon.service;

import java.util.List;

import com.toon.domain.MarkListVO;
import com.toon.domain.MarkVO;
import com.toon.domain.ReplyListVO;
import com.toon.domain.ReplyVO;
import com.toon.domain.ToonsViewVO;

public interface ToonService {
	
	//카테고리별 상품 리스트
		public List<ToonsViewVO> list(int cateCode, int level) throws Exception;
		
	// 작품조회
		public ToonsViewVO toonsView(int toonNum) throws Exception;
		
	// 작품 소감(댓글) 작성
		public void registReply(ReplyVO reply) throws Exception;
		
	// 작품 소감(댓글) 리스트
		public List<ReplyListVO> replyList(int toonNum) throws Exception;
	
	
	// 작품 소감(댓글) 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	// 아이디 체크
	public String idCheck(int repNum) throws Exception;

	
	// 작품 소감(댓글) 수정
	public void modifyReply(ReplyVO reply) throws Exception;

	
	// 책갈피 담기
	public void addMark(MarkListVO mark) throws Exception;

	// 책갈피 리스트
	public List<MarkListVO> markList(String userId) throws Exception;

	// 책갈피 삭제
	public void deleteMark(MarkVO mark) throws Exception;
	
	//조회수 증가
	public void addView(int view) throws Exception;
	
	//추천수 증가
	public void addGood(int toonNum) throws Exception;
	/*
	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;
	
	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	// 카트 비우기
	public void cartAllDelete(String userId) throws Exception;
	
	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;

	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	 */
}
