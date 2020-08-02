package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class BoardDTO {
	private int boardNum;
	private String boardSubject;
	private String memberId;
	private String boardContent;
	private String boardFile; 
	private String boardDate;
}
  