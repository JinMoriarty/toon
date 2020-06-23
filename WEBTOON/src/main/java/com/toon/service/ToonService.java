package com.toon.service;

import java.util.List;
import com.toon.domain.ToonsViewVO;

public interface ToonService {
	
	//카테고리별 상품 리스트
		public List<ToonsViewVO> list(int cateCode, int level) throws Exception;
}
