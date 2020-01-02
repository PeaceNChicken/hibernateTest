package com.tistory.herobong.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	//lombok - @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor 를 가지고 있는 어노테이션
@Builder	//	lombok - 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name="user_role"
)
public class UserRole {

	@Id
	@Column(name="user_role_idx")
	private long userRoleIdx;
	
	private String role;
	
	public UserRole(String role) {
		this.role = role;
	}
}
