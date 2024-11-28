package com.vamos.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vamos.spring.test.ajax.domain.Favorite;

@Mapper
public interface AjaxRepository {
	public int createFavorite(@Param("name") String name
							,@Param("url") String url);
	
	public List<Favorite> getList();
	
	public int isDuplicateUrl(@Param("url") String url);
	
	// 특정 즐겨찾기 행 삭제
	// input : 삭제 대상 id
	// 기능 : delete 쿼리 수행으로 특정 행 삭제
	// output : 실행될 행의 개수
	public int deleteFavorite(@Param("id") int id);
}
