package com.tistory.herobong.services.user;

import java.util.List;

import com.tistory.herobong.models.user.User;

public interface UserServices {

	public User save(User user, String result);
	
	public List<User> findAll();
	
	public List<User> findByUserGender(Character gender);	
	public List<User> findByUserIdx(Long idx);
	
	//public List<User> findByUserAgeLessThan(Integer age);
	public List<User> findByUserAgeLessThanEqual(Integer age);
}
