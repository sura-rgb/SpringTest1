package com.vamos.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("lifecycle/test02")
@RestController
public class Test02RestController {

	@RequestMapping("/1")
	public List<Map<String,Object>> movieList() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieMap = new HashMap<>();
		movieMap.put("title","기생충");
		movieMap.put("director","봉준호");
		movieMap.put("time","131");
		movieMap.put("rate","15");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("title","인생은 아름다워");
		movieMap.put("director","로베르토 베니니");
		movieMap.put("time","116");
		movieMap.put("rate","0");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("title","인셉션");
		movieMap.put("director","크리스토퍼 놀란");
		movieMap.put("time","147");
		movieMap.put("rate","12");
		movieList.add(movieMap);
		
		return movieList;
	}
	
	
	@RequestMapping("/2")
	public List<Post> postList() {
		List<Post> postList = new ArrayList<>();
		Post post = new Post("안녕하세요 가입인사 드립니다,", "hagulu", "안녕하세요, 가입했어요, 잘부탁드려요");
		postList.add(post);
		postList.add(new Post("헐 대박","bada","오늘 목요일이었어, 금요일 인줄"));
		postList.add(new Post("오늘 데이트한 이야기 해드릴게요","dulumary","..."));
		
		return postList;
		
		
	}
	@RequestMapping("/3")
	public ResponseEntity<Post> postError() {
		Post post = new Post("안녕하세요 가입인사 드립니다,", "hagulu", "안녕하세요, 가입했어요, 잘부탁드려요");
		ResponseEntity <Post> entity = new ResponseEntity<>(post,HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
		
	}
	
}
