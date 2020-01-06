package com.tistory.herobong.services.user;

import java.util.Date;
import java.util.List;

import com.tistory.herobong.models.user.User;
import com.tistory.herobong.models.user.UserRole;

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
	
	public List<User> findByUserNameLike(String name);

	public List<User> findByUserAgeOrderByUserNameDesc(Long age);
	
	public List<User> findByUserIdxIn(List<Long> idx);
	
	public List<User> findByUserRole(UserRole userRole);
	
	//public List<User> findByCreatedAtBetweenOrderByUserAgeAsc(Date sAt, Date eAt);
	
	//public List<User> findByCreatedAtBetweenAndUserNameLikeOrderByUserAgeAsc(Date sAt, Date eAt, String name);

	public List<User> findByCreatedAtBetweenAndUserNameLikeAndUserAddressEqualsOrderByUserAgeAsc(Date sAt, Date eAt, String name, String address);
}
