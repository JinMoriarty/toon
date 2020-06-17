package com.toon.service;

import java.util.List;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;
import com.toon.domain.ToonsViewVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 작품 등록
	public void register(ToonVO vo) throws Exception;

	// 작품 목록
	public List<ToonVO> toonslist() throws Exception;

	// 작품 조회 + 카테고리 조인
	public ToonsViewVO toonsView(int toonNum) throws Exception;
	
	//작품 수정
	public void toonsModify(ToonVO vo) throws Exception;
	
	//작품 삭제
	public void toonsDelete(int toonNum) throws Exception;
} 