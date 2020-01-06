package com.tistory.herobong.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.herobong.models.user.UserRole;
import com.tistory.herobong.repositories.user.UserRoleRepository;
import com.tistory.herobong.services.user.UserRoleServices;

@Transactional
@Service("UserRoleServices")
public class UserRoleServicesImpl implements UserRoleServices {

	@Autowired
	UserRoleRepository userRoleRepository;
	
	public UserRole findByUserRoleIdx(Long role) {
		return userRoleRepository.findByUserRoleIdx(role);
	}
}
