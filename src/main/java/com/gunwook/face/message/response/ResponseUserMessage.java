package com.gunwook.face.message.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserMessage {
	private String token;
	private Long user_id;
	private String email;
	private String name;
	private int status;

	public ResponseUserMessage(String token , Long user_id , int status , String email , String name) {
		this.token = token;
		this.user_id = user_id;
		this.status = status;
		this.email = email;
		this.name = name;
	}
}
