package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Participants {
	private int participantId;
	private String summonerName;
	private String champName;
}
