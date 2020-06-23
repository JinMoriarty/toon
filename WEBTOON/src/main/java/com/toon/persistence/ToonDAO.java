package com.toon.persistence;

import java.util.List;
import com.toon.domain.ToonsViewVO;

public interface ToonDAO {
	

	//카테고리별 상품 리스트 1차
	public List<ToonsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	//카테고리별 상품 리스트 2차
	public List<ToonsViewVO> list(int cateCode) throws Exception;
}
