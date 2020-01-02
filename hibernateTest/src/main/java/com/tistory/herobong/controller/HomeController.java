package com.tistory.herobong.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String userInsert(User user, @RequestParam("role") String result) {
		//System.out.println(result + "::: HomeController.java");
		userServices.save(user, result);
		return "redirect:/userList";
	}
	
	@GetMapping("/userList")
	public String userList(Model model) {
		List<User> userList = userServices.findAll();
		//System.out.println(userList.toString() + ":::HomeController.java");
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearch")
	public String userSearch(Character gender, Model model) {
		gender = 'm';
		List<User> userList = userServices.findByUserGender(gender);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchIdx")
	public String userSearchIdx(Long idx, Model model) {
		idx = (long) 2;
		List<User> userList = userServices.findByUserIdx(idx);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchAge")
	public String userSearchAge(Long age, Model model) {
		age = (long) 30;
		List<User> userList = userServices.findByUserAgeLessThanEqual(age);	//age값 이하인 user 리스트
		//List<User> userList = userServices.findByUserAgeLessThan(age);	age값 미만인 user 리스트
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchAnd")
	public String userSearchAnd(Long idx, String name, Model model) {
		idx = (long) 11;
		name = "박시연";
		List<User> userList = userServices.findByUserIdxAndUserName(idx, name);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	
}
