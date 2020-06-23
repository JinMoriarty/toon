package com.toon.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
}
