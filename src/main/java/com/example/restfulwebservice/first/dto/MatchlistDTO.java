package com.example.restfulwebservice.first.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchlistDTO {
	private int startIndex;
	private int totalGames;
	private int endIndex;
	private List<MatchReferenceDTO> matches;
}
