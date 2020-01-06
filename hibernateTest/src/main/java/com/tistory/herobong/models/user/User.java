package com.tistory.herobong.models.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data	//lombok - @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor 를 가지고 있는 어노테이션
@Builder	//	lombok - 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name="user"
)
public class User {

	
	@Id	// pk키 설정해주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto_increment 어노테이션
	@Column(name="user_idx", nullable = false)	//column 이름 설정, null 허용 여부
	private long userIdx;
	
	@Column(name="user_name", nullable = false)
	private String userName;
	
	@Column(name="user_gender", nullable = true)
	private Character userGender;

	@Column(name="user_address", nullable = true)
	private String userAddress;
	
	@Column(name="user_email", nullable = true, length=55)
	private String userEmail;
	
	@Column(name="user_age", nullable = true, length=3)
	private long userAge;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@JoinColumn(name="user_role")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserRole userRole;
	
	//@Transient 테이블의 컬럼(=필드)에 추가하고 싶지 않은 속성이 있을때 사용하는 어노테이션
	//예) 비밀번호가 제대로 입력했는지 확인차 한 번 더 입력하게 하는 부분
	
}
