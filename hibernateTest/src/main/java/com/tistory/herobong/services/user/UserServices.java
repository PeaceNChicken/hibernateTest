package com.tistory.herobong.services.user;

import java.util.Date;
import java.util.List;

import com.tistory.herobong.models.user.User;

public interface UserServices {

	public User save(User user, String result);
	
	public List<User> findAll();
	
	public List<User> findByUserGender(Character gender);	
	public List<User> findByUserIdx(Long idx);
	
	public List<User> findByUserAgeLessThanEqual(Long age);
	
	public List<User> findByUserIdxAndUserName(Long idx, String name);
	
	public List<User> findByUserGenderOrUserAddress(Character gender, String address);
	
	public List<User> findByUserAddressIs(String address);
	
	public List<User> findByCreatedAtBetween(Date sAt, Date eAt);
	
	public List<User> findByUserAgeGreaterThanEqual(Long age);
	
	public List<User> findByUserNameIsNotNull();
	
	public List<User> findByCreatedAtAfter(Date startDate);
}
