package com.vamos.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vamos.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	// 리스트를 얻어온다
	
	// sotre 테이블 전체 행 조회 (서비스에서 써야하는데 없으니까 만드는것)
	// XML에 SQL 쿼리를 작성하여 데이터베이스에 접근하고, 자바 객체와 매핑해주는 프레임워크 사용
	// build.gradle 에서 dependancies 추가
	// application.properties에서 접속할 DB 정보 
	// 해당 인터페이스 매퍼와 연결
	// 리턴타입을 리스트로 잡는데 , 이때 첫행의 정보를 저장할 클래스를 따로 만들어 리턴타입으로 잡아주면 간편
	// 클래스 생성(domain) 한행의 정보를 멤버변수로
	// 생성한 domain 클래스를 리턴타입으로
	// 그리하여 만든 이 메소드를 xml을 통해 구현하는 형태로 사용할것
	// xml 없으니까 만든다, 나뭇잎 마지막에 매퍼설정해둔거에 맞추기
	// mappers/*Mapper.xml -> 리소스밑에 mappers 패키지 생성후에, (매퍼이름)Mapper.xml 파일 생성
	// 파일안에 dtt 태그를 이용하여 태그생성
	// 매퍼 태그를통해 연동할 레파지토리경로 namespace로 잡아주고 안에 구현할 내용 생성 (id="메소드이름", 파라메터(없으면 생략), resultType="리턴타입")
	// 즉, 여기서 repository 인터페이스 안에 구현할 메소드 -> 메퍼라는 태그안에 구현할 내용 똑같음
	// 마이바티스가 xml 과 매칭하여 사용할수있게해줌
	public List<Store> selectStoreList();
	
	
}
