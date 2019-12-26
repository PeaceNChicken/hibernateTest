package com.tistory.herobong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		//System.out.println("index페이지 출력");
		return "/home";
	}
	
	@GetMapping("/user")
	public String userPage() {
		//System.out.println("user.jsp :: HomeController.java");
		return "/user/user";
	}
}
