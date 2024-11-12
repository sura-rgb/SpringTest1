package com.vamos.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.test.database.domain.Store;
import com.vamos.spring.test.database.service.StoreService;

// request, response
@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@ResponseBody
	@RequestMapping("/db/store/list")
	public List<Store> storeList() {
		
		// 가게 정보 리스트 얻어오기
		// 서비스안의 메소드를 사용하여 얻어와야 하는데 없으니까 서비스 패키지를 안에 만들어서 기능 구현
		
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}
