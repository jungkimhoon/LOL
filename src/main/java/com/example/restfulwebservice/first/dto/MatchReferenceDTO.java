package com.example.restfulwebservice.first.dto;

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
	private String win; 
	private String kills;
	private String assists;
	private String deaths; 
} 
