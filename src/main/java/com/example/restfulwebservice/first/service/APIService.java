package com.example.restfulwebservice.first.service;

import java.util.HashMap;
import java.util.List;

import com.example.restfulwebservice.first.dto.ChampionIdToKeyDTO;
import com.example.restfulwebservice.first.dto.ChampionInfoDTO;
import com.example.restfulwebservice.first.dto.LeagueEntryDTO;
import com.example.restfulwebservice.first.dto.MatchlistDTO;
import com.example.restfulwebservice.first.dto.SummonerDTO;

public interface APIService {
	
	public HashMap<Integer, String> ChampIdToKey();
  
	public SummonerDTO getSummoner(String searchId);

	public List<LeagueEntryDTO> getLeagueEntry(String id); 

	public ChampionInfoDTO getChapionInfo();

	public List<String> getImgName(ChampionInfoDTO championInfoDTO, HashMap<Integer, String> map);

	public MatchlistDTO getMatchList(String accountId, HashMap<Integer, String> map);
	
	public HashMap<String, String> SpellKeyToName();
}
