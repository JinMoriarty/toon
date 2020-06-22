package com.toon.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;
import com.toon.domain.ToonsViewVO;


@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	// 매퍼 
	private static String namespace = "com.toon.mappers.adminMapper";
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception{
		return sql.selectList(namespace + ".category");
	}

	// 작품 등록
	@Override
	public void register(ToonVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	
	// 작품 목록
	@Override
	public List<ToonsViewVO> toonslist() throws Exception {
		return sql.selectList(namespace + ".toonslist");
	}
	
	//작품 조회 + 카테고리 조인
	@Override
	public ToonsViewVO toonsView(int toonNum) throws Exception{
		return sql.selectOne(namespace+".toonsView", toonNum);
	}
	
	//작품 수정
	@Override
	public void toonsModify(ToonVO vo) throws Exception{
		sql.update(namespace + ".toonsModify", vo);
	}
	
	//작품 삭제
	@Override
	public void toonsDelete(int toonNum) throws Exception{
		sql.delete(namespace+".toonsDelete", toonNum);
	}
	

} 