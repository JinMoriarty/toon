package com.toon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;
import com.toon.domain.ToonsViewVO;
import com.toon.persistence.AdminDAO;
 
@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception{
		return dao.category();
	}
	
	// 작품 등록
	@Override
	public void register(ToonVO vo) throws Exception {
		dao.register(vo);		
	}
	
	// 작품 목록
	@Override
	public List<ToonsViewVO> toonslist() throws Exception {
		System.out.println("서비스");
		return dao.toonslist();
	}
	
	// 작품 조회 + 카테고리 조인
	@Override
	public ToonsViewVO toonsView(int toonNum) throws Exception {
		return dao.toonsView(toonNum);
		}
	
	//작품 수정
	@Override
	public void toonsModify(ToonVO vo) throws Exception{
		dao.toonsModify(vo);
	}
	
	//작품 삭제
	@Override
	public void toonsDelete(int toonNum) throws Exception{
		dao.toonsDelete(toonNum);
	}
}