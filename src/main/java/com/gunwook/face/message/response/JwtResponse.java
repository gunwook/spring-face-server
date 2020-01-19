package com.gunwook.face.message.response;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class JwtResponse {
	private String token;
	private String name;
	private Long user_id;
	private int status;
	private String email;


	public JwtResponse(String accessToken, String name, int status , Long userId , String email) {
		this.token = accessToken;
		this.name = name;
		this.status = status;
		this.user_id = userId;
		this.email = email;
	}
}