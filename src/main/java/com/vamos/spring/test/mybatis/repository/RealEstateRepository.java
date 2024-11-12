package com.vamos.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vamos.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	// 전달받은 id와 일치하는 real_estate행 조회
	public RealEstate selectRealEstate(@Param("id")int id);
	
	// 전달받은 월세보다 낮은 행 조회
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	
	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area")int area, @Param("price")int price);
	
	// 마이바티스 특성상, 행의 개수가 리턴되기때문에 int 
	public int insertRealEstateByObject(RealEstate realEstate);
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			,@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			,@Param("rentPrice")int rentPrice);
	
	public int updateEralEstate(
			@Param("id")int id
			,@Param("type")String type
			,@Param("price") int price);
	
	public int deleteRealEstate(@Param("id")int id);
}
