package com.toon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toon.domain.ToonsViewVO;
import com.toon.persistence.ToonDAO;

@Service
public class ToonServiceImpl implements ToonService {

	@Inject
	private ToonDAO dao;

	// 카테고리별 상품 리스트
	@Override
	public List<ToonsViewVO> list (int cateCode, int level) throws Exception{
		
		int cateCodeRef = 0;
		
		if(level == 1) {//1차
			cateCodeRef = cateCode;
			return dao.list(cateCode,cateCodeRef);
		}else { //2차
			return dao.list(cateCode);
		}
	}
}
