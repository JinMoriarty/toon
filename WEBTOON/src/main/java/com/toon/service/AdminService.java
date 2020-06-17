package com.toon.service;

import java.util.List;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 작품 등록
	public void register(ToonVO vo) throws Exception;

	// 작품 목록
	public List<ToonVO> toonslist() throws Exception;
	
} 