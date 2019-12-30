package com.tistory.herobong.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.services.user.UserServices;

@Controller
public class HomeController {

	@Resource(name="UserServices")
	UserServices userServices;
	
	@GetMapping("/")
	public String index() {
		return "/home";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "/user/user";
	}
	
	@PostMapping("/userInsert")
	public String userInsert(User user) {
		userServices.save(user);
//		return "/user/userList";
		return "";
		
	}
	
	@GetMapping("/userList")
	public String userList(Model model) {
		List<User> userList = userServices.findAll();
		System.out.println(userList.toString() + ":::UserServices.java");
		model.addAttribute("userList", userList);
		
		return "/user/userList";
	}
}
