package com.vamos.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.spring.test.ajax.domain.Favorite;
import com.vamos.spring.test.ajax.repository.AjaxRepository;

@Service

public class AjaxService {
	@Autowired
	private AjaxRepository ajaxRepository;
	
	public int createFavorite(String name, String url) {
		int count = ajaxRepository.createFavorite(name, url);
		return count;
	}
	
	public List<Favorite> getList() {
		List<Favorite> favoriteList = ajaxRepository.getList();
		return favoriteList;
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = ajaxRepository.isDuplicateUrl(url);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 특정 즐겨찾기 삭제
	// input : 삭제 대상 id (parameter)
	// 기능 : id와 대응되는 즐겨 찾기 삭제
	// output : 삭제된 행의 개수
	public int deleteFavorite(int id) {
		int count = ajaxRepository.deleteFavorite(id);
		return count;
	}
	
}
