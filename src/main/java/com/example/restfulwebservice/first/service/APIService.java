package com.example.restfulwebservice.first.service;

import java.util.HashMap;
import java.util.List;

import com.example.restfulwebservice.first.dto.ChampionInfoDTO;
import com.example.restfulwebservice.first.dto.LeagueEntryDTO;
import com.example.restfulwebservice.first.dto.MatchlistDTO;
import com.example.restfulwebservice.first.dto.SummonerDTO;

public interface APIService {
	HashMap<Integer, String> ChampIdToKey();
 
	SummonerDTO getSummoner(String searchId);

	LeagueEntryDTO getLeagueEntry(String id);

	ChampionInfoDTO getChapionInfo();

	List<String> getImgName(ChampionInfoDTO championInfoDTO, HashMap<Integer, String> map);

	MatchlistDTO getMatchList(String accountId, HashMap<Integer, String> map);
}
