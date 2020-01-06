package com.tistory.herobong.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tistory.herobong.models.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	//public UserRole save(UserRole userRole);
	
	public UserRole findByRole(String role);
	
	public UserRole findByUserRoleIdx(Long role);
}
