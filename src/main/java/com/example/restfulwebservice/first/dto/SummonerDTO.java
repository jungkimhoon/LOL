package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummonerDTO {
	private int profileIconId;
	private String name;
	private String puuid;
	private long summonerLevel;
	private long revisionDate;
	private String id;
	private String accountId; 
}
