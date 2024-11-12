package com.vamos.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.test.mybatis.domain.RealEstate;
import com.vamos.spring.test.mybatis.service.RealEstateService;
@RequestMapping("/mybatis/realestate")
@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/select/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		// parameter로 전달받은 id와 일치하는 부동산 정보 얻어오기
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	@ResponseBody
	@RequestMapping("/select/2")
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent")int rentPrice) {
		// parameter로 받은 월세 금액보다 더 낮은 매물정보 얻어오기
		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	@ResponseBody
	@RequestMapping("/select/3")
	public List<RealEstate> realEstateByAreaAndPrice(@RequestParam("area")int area,@RequestParam("price") int price) {
		
		// parameter로 전달받은 넓이보다 크고, 가격보다 작은 매물 얻어오기
		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaAndPrice(area, price);
		
		return realEstateList;
	}
	
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지옹 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/insert/2")
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addRealEstate(realtorId, "샹떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 :" + count;
	}
	
	// 문자열을 받아 그대로 돌려주고싶으니까 쓰는거
	@ResponseBody
	@RequestMapping("/update")
	public String updateRealEstate() {
		int count = realEstateService.updateRealEstate(22, "전세", 70000);
		return "수행 성공 : " + count;
	}
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id")int id) {
		int count = realEstateService.deleteRealEstate(id);
		return "삭제 성공 : " + count;
	}
	
}
