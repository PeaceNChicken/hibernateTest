package com.tistory.herobong.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tistory.herobong.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	public List<User> findAll();
}
