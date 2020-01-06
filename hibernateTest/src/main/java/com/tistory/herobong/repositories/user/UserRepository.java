package com.tistory.herobong.repositories.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.models.user.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	//public List<User> findAll();
	//findAll()도 jpaRepository에 이미 들어가있어서 주석처리해도 에러없다. save()도 마찬가지
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
	public List<User> findByUserNameLike(String name);
	public List<User> findByUserAgeOrderByUserNameDesc(Long age);
	public List<User> findByUserIdxIn(List<Long> idx);
	public List<User> findByUserRole(UserRole userRole);
	
}
