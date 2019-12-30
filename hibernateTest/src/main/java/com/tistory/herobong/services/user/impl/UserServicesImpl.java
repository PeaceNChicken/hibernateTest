package com.tistory.herobong.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.repositories.user.UserRepository;
import com.tistory.herobong.services.user.UserServices;

@Service("UserServices")
public class UserServicesImpl implements UserServices {

	@Autowired UserRepository userRepository;
	
	public User save(User user) {
		
		
		System.out.println(user.getUserEmail());
		
		return userRepository.save(user) ;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
