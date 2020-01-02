package com.tistory.herobong.services.user.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.models.user.UserRole;
import com.tistory.herobong.repositories.user.UserRepository;
import com.tistory.herobong.repositories.user.UserRoleRepository;
import com.tistory.herobong.services.user.UserServices;

@Service("UserServices")
public class UserServicesImpl implements UserServices {

	@Autowired 
	UserRepository userRepository;	
	@Autowired 
	UserRoleRepository userRoleRepository;
	
	@PostConstruct	//	was시작시 객체 초기화와 함께 의존성 설정하는 어노테이션이라고 한다
	public void insertUserRoles() {
		if(userRoleRepository.findByRole("ADMIN") == null) {
			userRoleRepository.save(new UserRole("ADMIN"));
		}
		if(userRoleRepository.findByRole("USER") == null) {
			userRoleRepository.save(new UserRole("USER"));
		}
	}
	
	public User save(User user, String result) {
		user.setUserRole(userRoleRepository.findByRole(result));
		return userRepository.save(user) ;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public List<User> findByUserGender(Character gender){
		return userRepository.findByUserGender(gender);
	}
	
	public List<User> findByUserIdx(Long idx){
		return userRepository.findByUserIdx(idx);
	}
	
	public List<User> findByUserAgeLessThanEqual(Long age){
		return userRepository.findByUserAgeLessThanEqual(age);
	}
	
	public List<User> findByUserIdxAndUserName(Long idx, String name){
		return userRepository.findByUserIdxAndUserName(idx, name);
	}
}
