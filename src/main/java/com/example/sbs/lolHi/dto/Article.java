package com.example.sbs.lolHi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private int id;
	private int memberId;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;
	
}
