package com.vamos.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Thymeleaf {
	
	@RequestMapping("/lifecycle/test03")
	public String thymleafTest() {
		return "lifecycle/test03";
	}
}
