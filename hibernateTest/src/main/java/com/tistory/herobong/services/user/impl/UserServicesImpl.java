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
	
	@PostConstruct	//	was시작시 bean 객체 초기화와 함께 의존성 설정하는 어노테이션이라고 한다. 최초 1번 실행
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

	public List<User> findByUserNameLike(String name){
		return userRepository.findByUserNameLike(name);
	}
	
	public List<User> findByUserAgeOrderByUserNameDesc(Long age){
		return userRepository.findByUserAgeOrderByUserNameDesc(age);
	}
	
	public List<User> findByUserIdxIn(List<Long> idx){
		return userRepository.findByUserIdxIn(idx);
	}
	
	public List<User> findByUserRole(UserRole userRole){
		return userRepository.findByUserRole(userRole);
	}
	
	/*
	 * public List<User> findByCreatedAtBetweenOrderByUserAgeAsc(Date sAt, Date
	 * eAt){ return userRepository.findByCreatedAtBetweenOrderByUserAgeAsc(sAt,
	 * eAt); }
	 */
	
	public List<User> findByCreatedAtBetweenAndUserNameLikeOrderByUserAgeAsc(Date sAt, Date eAt, String name){
		return userRepository.findByCreatedAtBetweenAndUserNameLikeOrderByUserAgeAsc(sAt, eAt, name);
	}
}
