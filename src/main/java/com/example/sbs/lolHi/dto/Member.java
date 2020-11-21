package com.example.sbs.lolHi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private String email;
	private String name;
	
	
	public boolean isAdmin() {
		return "sbsst".equals(loginId);
	}
}
