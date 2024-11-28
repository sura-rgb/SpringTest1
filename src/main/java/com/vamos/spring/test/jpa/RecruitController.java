package com.vamos.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.test.jpa.domain.Recruit;
import com.vamos.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/read")
@Controller
public class RecruitController {
	@Autowired
	private RecruitRepository recruitRepository;
	
	
	@ResponseBody
	@GetMapping("/1")
	public Recruit recruit1() {
		// id가 8인 공고
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
		
	}
	
	@GetMapping("/2")
	public List<Recruit> readRecruitByCompanyId(@RequestParam("companyId") int companyId) {
		
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
			
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/3")
	public List<Recruit> recruit3() {
		// 웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
//		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
//		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
//		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		return recruitRepository.findByNativeQuery("2026-04-10 00:00:00", 8100, "정규직");
												//LocalDate.of(2026, 4, 10) repository 타입도 LocalDate로 바꿔주고
	}
	
}
//