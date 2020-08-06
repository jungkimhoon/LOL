package com.example.restfulwebservice.first.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchReferenceDTO {
	private long gameId;
	private String role;
	private int season;
	private String platformId;
	private int champion;
	private String championName;
	private int queue;
	private String lane;
	private long timestamp;
	private String gameDuration;
	
	private String win;  
	
	private String kills;
	private String assists;
	private String deaths; 
	
	private String item0;
	private String item1;
	private String item2; 
	private String item3;
	private String item4;
	private String item5;
	private String item6;
	
	private String spell1Id;  
	private String spell2Id;  
	
	private List<Participants> participantsList;
} 
