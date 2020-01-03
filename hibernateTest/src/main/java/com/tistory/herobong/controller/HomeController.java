package com.tistory.herobong.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@GetMapping("/userSearchOr")
	public String userSearchOr(Character gender, String address, Model model) {
		gender = 'f';
		address = "서울";
		List<User> userList = userServices.findByUserGenderOrUserAddress(gender, address);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchIs")	//Is 대신 Equals을 써도 동일
	public String userSearchIs(String address, Model model) {
		address = "인천";
		List<User> userList = userServices.findByUserAddressIs(address);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchBetween")
	public String userSearchBetween(Model model) throws ParseException {
		String startAt = "2019-12-10";
		String endAt = "2019-12-20";
		Date sAt = new SimpleDateFormat("yyyy-MM-dd").parse(startAt);
		Date eAt = new SimpleDateFormat("yyyy-MM-dd").parse(endAt);
		List<User> userList = userServices.findByCreatedAtBetween(sAt, eAt);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchGreater")
	public String userSearchGreater(Long age, Model model) {
		age = (long) 30;
		//List<User> userList = userServices.findByUserAgeGreaterThan(age);
		List<User> userList = userServices.findByUserAgeGreaterThanEqual(age);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
	
	@GetMapping("/userSearchIsNotNull") 
	public String userSearchIsNotNull(Model model) { 
		List<User> userList =userServices.findByUserNameIsNotNull(); 
		model.addAttribute("userList", userList); 
		return "/user/userList"; 
	}
	 
	@GetMapping("userSearchAfter")
	public String userSearchAfter(Model model) throws ParseException {
		String startAt = "2019-12-15";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startAt);
		List<User> userList = userServices.findByCreatedAtAfter(startDate);
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
}
