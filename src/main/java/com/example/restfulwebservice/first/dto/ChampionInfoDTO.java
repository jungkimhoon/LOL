package com.example.restfulwebservice.first.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionInfoDTO {
	private int maxNewPlayerLevel;
	private List<Integer> freeChampionIdsForNewPlayers;
	private List<Integer> freeChampionIds;
}
