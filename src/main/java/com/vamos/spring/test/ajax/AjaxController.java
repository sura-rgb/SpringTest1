package com.vamos.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.test.ajax.domain.Favorite;
import com.vamos.spring.test.ajax.service.AjaxService;

@RequestMapping("/ajax/favorite")
@Controller
public class AjaxController {
	
	@Autowired
	private AjaxService ajaxService;
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		int count = ajaxService.createFavorite(name, url);
		
		// 성공: {"result":"success"}
		// 실패: {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	@ResponseBody
	@PostMapping("/duplicate")
	public Map<String,Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean duplicate = ajaxService.isDuplicateUrl(url);
		
		Map<String,Boolean> resultMap = new HashMap<>();
			// 중복됨 {"isDuplicate":true}
			// 중복안됨{"isDuplicate":false}
		resultMap.put("isDuplicate", duplicate);
		
//		if(duplicate) {
//			resultMap.put("isDuplicate",true);
//		} else {
//			resultMap.put("isDuplicate", false);
//		}
		
		return resultMap;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = ajaxService.deleteFavorite(id);
		Map<String, String> resultMap = new HashMap<>();
		// 성공 : {"result" : "success"}
		// 실패 : {"result" : "fail"}
		if(count == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		
		return resultMap;
	}
	
	
	@GetMapping("/input")
	public String addFavorite() { 
		return "ajax/favorite/test01";
	}
	
	
	@GetMapping("/list")
	public String listView(Model model) {
		
		List<Favorite> favoriteList = ajaxService.getList();
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/test02";
	}
}
