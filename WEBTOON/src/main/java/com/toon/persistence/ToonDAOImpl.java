package com.toon.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.toon.domain.MarkListVO;
import com.toon.domain.MarkVO;
import com.toon.domain.ReplyListVO;
import com.toon.domain.ReplyVO;
import com.toon.domain.ToonsViewVO;

@Repository
public class ToonDAOImpl implements ToonDAO {
	
	@Inject
	private SqlSession sql;
	
		// 매퍼 
		private static String namespace = "com.toon.mappers.toonMapper";
		
		// 카테고리별 상품 리스트 1차
		@Override
		public List<ToonsViewVO> list(int cateCode, int cateCodeRef) throws Exception{
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("cateCode", cateCode);
			map.put("cateCodeRef", cateCodeRef);
			
			return sql.selectList(namespace + ".list_1", map);
		}
		
		// 카테고리별 상품 리스트 2차
		@Override
		public List<ToonsViewVO> list(int cateCode) throws Exception{
					
			return sql.selectList(namespace + ".list_2", cateCode);
		}
		
		//작품 조회
		@Override
		public ToonsViewVO toonsView(int toonNum) throws Exception{
			return sql.selectOne("com.toon.mappers.adminMapper.toonsView", toonNum);
		}
		
		// 작품 소감(댓글) 작성
		@Override
		public void registReply(ReplyVO reply) throws Exception {
			sql.insert(namespace + ".registReply", reply);
		}
		
		// 작품 소감(댓글) 리스트
		@Override
		public List<ReplyListVO> replyList(int toonNum) throws Exception {
			return sql.selectList(namespace + ".replyList", toonNum);
		}
		
	

	// 작품 소감(댓글) 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}

	// 아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}
	
	
	// 작품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

	
	// 책갈피 담기
	@Override
	public void addMark(MarkListVO mark) throws Exception {
		sql.insert(namespace + ".addMark", mark);
	}

	// 책갈피 리스트
	@Override
	public List<MarkListVO> markList(String userId) throws Exception {
		return sql.selectList(namespace + ".markList", userId);
	}
	
	// 책갈피 삭제
	@Override
	public void deleteMark(MarkVO mark) throws Exception {
		sql.delete(namespace + ".deleteMark", mark);
	}
	
	//조회수 증가
	@Override
	public void addView(int view) throws Exception {
		sql.update(namespace + ".addView", view);
	}
	
	//추천수 증가
	@Override
	public void addGood(int good) throws Exception {
		sql.update(namespace + ".addGood", good);
	}
	
	/*
	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace + ".orderInfo", order);
	}
	
	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}

	// 카트 비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace + ".cartAllDelete", userId);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderList", order);
	}

	// 특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}
		 */
}
