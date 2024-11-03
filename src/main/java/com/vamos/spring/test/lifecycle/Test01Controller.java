package com.vamos.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lifecycle/test01")
@Controller
public class Test01Controller {
	
		
		@ResponseBody
		@RequestMapping("/1")
		public String stringResponse() {
		return "<h2> 테스트 프로젝트 완성 </h2><h4>해당 프로젝트를 통해 문제풀이를 진행합니다.</h4>";
		}
		
		@ResponseBody
		@RequestMapping("/2")
		public Map<String, Integer> mapResponse() {
			
			// 제이스 형태와 유사한 형태의 자바 객채를만들어서 그 객채를 리스폰바디를 기반으로 리턴해주면
			// 해당 객체가 제이슨 문자로 변경되서 전달
			// {"국어" : 90, "수학" : 95, "영어" : 100 }
			Map<String, Integer> scoreMap = new HashMap<>();
			scoreMap.put("국어", 90);
			scoreMap.put("수학", 95);
			scoreMap.put("영어", 100);
			
			return scoreMap;
		
	}
}
