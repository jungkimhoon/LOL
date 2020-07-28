package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class LeagueEntryDTO {
	private String leagueId;
	private String summonerId;
	private String summonerName;
	private String queueType;
	private String tier;
	private String rank;
	private int leaguePoints;
	private int wins;
	private int losses;
}
