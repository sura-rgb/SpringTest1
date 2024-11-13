package com.vamos.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.test.mvc.domain.Seller;
import com.vamos.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("profileImage") String profileImage
			,@RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "redirect:/mvc/seller/info";
	}
	

	
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	
	@GetMapping("/info")
	public String sellerInfo(
			// required = 기본 true, 즉 id 값이 필수로 존재하여야 한다, false = 필수로 두지않겠다
			// 기본자료형이 아닌 Integer 사용이유는 파라메터 전달이 안됐을시 id에 null을 대입시키려 시도하는데
			// 기본자료형은 null을 가질수 없다. 하여 래퍼클래스 사용, 파라메터없으면 null이됨
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		Seller seller = null;
		if(id == null) {
			seller = sellerService.lastSeller();
		} else {
			seller = sellerService.sellerId(id);
		}
		model.addAttribute("seller",seller);
		return "mvc/sellerInfo";
	}
	

	
	
}
