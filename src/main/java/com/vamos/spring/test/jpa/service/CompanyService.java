package com.vamos.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vamos.spring.test.jpa.domain.Company;
import com.vamos.spring.test.jpa.repository.CompanyRepository;

public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
							.name(name)
							.business(business)
							.scale(scale)
							.headcount(headcount)
							.build();
		
		// 확인한 정보를 클래스에 저장 한행에
 		company = companyRepository.save(company);
 		
 		return company;
		
	}
	
	// id를 전달받고, 해당하는 회사의 규모와 사원수를 수정하는 기능
	public Company updateCompany(int id, String scale, int headcount) {
		// 업데이트할 대상 행의 객체를 얻는다. 
		// 해당 객체의 값을 수정한다. 
		// 해당 객체를 다시 저장한다. 
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		Company company = optionalCompany.orElse(null);
		
		if(company != null) {
			company = company.toBuilder().scale(scale).headcount(headcount).build();
			company = companyRepository.save(company);
		}
		
		return company;
	
	}
	
	public void deleteCompany(int id) {
		// 삭제할 대상 행의 객체를 얻는다. 
		// 객체를 기반으로 삭제한다. 
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		//isPresent() 널이 아닌값을 가지고있을때
//		if(optionalCompany.isPresent()) {
//			companyRepository.delete(optionalCompany.get());
//		}
		
		// 람다식 표현
		// null이 아닐때 수행할 기능등록
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
		
	
	}
}
