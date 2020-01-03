package com.tistory.herobong.services.user.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.models.user.UserRole;
import com.tistory.herobong.repositories.user.UserRepository;
import com.tistory.herobong.repositories.user.UserRoleRepository;
import com.tistory.herobong.services.user.UserServices;

@Transactional
@Service("UserServices")
public class UserServicesImpl implements UserServices {

	@Autowired 
	UserRepository userRepository;	
	@Autowired 
	UserRoleRepository userRoleRepository;
	
	@PostConstruct	//	was시작시 객체 초기화와 함께 의존성 설정하는 어노테이션이라고 한다
	public void insertUserRoles() {
		if(userRoleRepository.findByRole("ADMIN") == null) {
			userRoleRepository.save(new UserRole(1, "ADMIN"));
		}
		if(userRoleRepository.findByRole("USER") == null) {
			userRoleRepository.save(new UserRole(2, "USER"));
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
	
	public List<User> findByUserGenderOrUserAddress(Character gender, String address){
		return userRepository.findByUserGenderOrUserAddress(gender, address);
	}
	
	public List<User> findByUserAddressIs(String address){
		return userRepository.findByUserAddressIs(address);
	}
	
	public List<User> findByCreatedAtBetween(Date sAt, Date eAt){
		return userRepository.findByCreatedAtBetween(sAt, eAt);
	}
	
	public List<User> findByUserAgeGreaterThanEqual(Long age){
		return userRepository.findByUserAgeGreaterThanEqual(age);
	}
	
	public List<User> findByUserNameIsNotNull(){ 
		return userRepository.findByUserNameIsNotNull(); 
	}
	
	public List<User> findByCreatedAtAfter(Date startDate){
		return userRepository.findByCreatedAtAfter(startDate);
	}

}
