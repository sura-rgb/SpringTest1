package com.vamos.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vamos.spring.test.thymeleaf.domain.Weather;
import com.vamos.spring.test.thymeleaf.service.WeatherService;


@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		
		// 날씨 기록 리스트를 얻어온다(service)
		// html에서 사용할데이터
		// model에 추가
		List<Weather> weather = weatherService.getWeahtherList();
		model.addAttribute("weather", weather);
		
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일")
//			@RequestParam("date") LocalDate date
//			,@RequestParam("weather") String weather
//			,@RequestParam("temperatures") double temperatures
//			,@RequestParam("precipitation") double precipitation
//			,@RequestParam("microDust") String microDust
//			,@RequestParam("windSpeed") double windSpeed
			// 리퀘스트 파라메터 값들을 저장할수 있는 클래스를 타입으로하는
			// 변수를 만들어서 모델 어트리뷰트 어노테이션을 붙여
			// 전달된 파라메터에 매칭된 멤버변수의 값이 저장된 객체가 얻어진다.
			// 멤버변수 위에 @DateTimeFormat 필요할시 붙여주면됨
			@ModelAttribute Weather weather) {
		
		int count = weatherService.addWeather(
				weather.getDate()
				,weather.getWeather()
				,weather.getTemperatures()
				,weather.getPrecipitation()
				,weather.getMicroDust()
				,weather.getWindSpeed());
		
		return "redirect:/thymeleaf/weather/list";
	}
	
	
	@GetMapping("/input")
	public String whatherInput() {
		return "thymeleaf/weather/input";
	}
	
}
