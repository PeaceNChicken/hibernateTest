package com.tistory.herobong.services.user;

import java.util.List;

import com.tistory.herobong.models.user.User;

public interface UserServices {

	public User save(User user);
	
	public List<User> findAll();
}
