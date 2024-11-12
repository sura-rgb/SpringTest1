package com.vamos.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.spring.test.database.domain.Store;
import com.vamos.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	
//	해당하는 Spring Bean을 찾아 사용할 수 있도록 한다.
//	객체 생성을 스프링 내부에서 수행하여 객체 관리를 위임한다.
//	DI(Depency Injection) 의존성 주입이라고 한다.
	//만든 클래스 스프링이 관리하도록, 필요할때마다 직접 생성하지않고, 바로쓸쑤있도록
	@Autowired
	private StoreRepository storeRepository;
	
	// !!!!!!가게 리스트 얻어와서 리턴한다!!!!!!!!! 이게 여기서 하는일 끝
	
	public List<Store> getStoreList() {
		// store 테이블의 모든 행 조회
		// 데이터베이스 처리는 서비스의 기능이아님, 또 거기가서 기능을 구현해야함 - > repository(인터페이스)
		
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
		
	}
}
