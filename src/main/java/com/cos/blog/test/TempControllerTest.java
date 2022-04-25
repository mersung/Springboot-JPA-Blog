package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controller는 파일을 리턴함
@Controller
public class TempControllerTest {
	
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로: src/main/resources/static
		//리턴명 : /home.html 로 해줘야함, 기본경로 뒤에 바로 이어붙이기 때문
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/Capture001.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
//		prefix: /WEB-INF/views/
//	    suffix: .jsp
// 	풀네임: /WEB-INF/views/test.jsp 로 바뀜
		return "test";
	}
}
