package com.vamos.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vamos.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {

	public int insertSeller(
			@Param("nickname") String nickname
			,@Param("profileImage") String profileImage
			,@Param("temperature") double temperature);
	
	
	public Seller lastSeller();
	
	public Seller sellerId(@Param("id") int id);
}
