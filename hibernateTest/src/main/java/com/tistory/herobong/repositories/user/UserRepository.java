package com.tistory.herobong.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tistory.herobong.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	//public List<User> findAll();
	//findAll()도 jpaRepository에 이미 들어가있어서 주석처리해도 에러없다. save()도 마찬가지
	public List<User> findByUserGender(Character gender);
	public List<User> findByUserIdx(Long idx);
	//public List<User> findByUserAgeLessThan(Integer age);
	public List<User> findByUserAgeLessThanEqual(Integer age);
}
