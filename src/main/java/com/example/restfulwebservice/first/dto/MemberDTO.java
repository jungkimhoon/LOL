package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String id;
	private String pwd;
	private String email;
	private String phone; 
}
 