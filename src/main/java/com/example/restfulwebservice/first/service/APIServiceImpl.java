package com.example.restfulwebservice.first.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfulwebservice.first.dao.MemberDAO;
import com.example.restfulwebservice.first.dto.ChampionInfoDTO;
import com.example.restfulwebservice.first.dto.LeagueEntryDTO;
import com.example.restfulwebservice.first.dto.MatchReferenceDTO;
import com.example.restfulwebservice.first.dto.MatchlistDTO;
import com.example.restfulwebservice.first.dto.SummonerDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonToken;

import oracle.net.aso.e;

@Service(value="apiService")  
public class APIServiceImpl implements APIService {
	final static String API_KEY = "RGAPI-65cb9b6b-61db-45ce-9d2a-4c13f82ac9fa";
	
	@Override
	public HashMap<Integer, String> ChampIdToKey() {
		String version = "10.6.1";
		String urlStr = "https://ddragon.leagueoflegends.com/cdn/"+version+"/data/en_US/champion.json";
		BufferedReader br = null;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		try {			  
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) {
				result = result + line;
			}

			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			JsonObject k1 = k.getAsJsonObject("data");
			
			
			for(String str : k1.keySet()) {
				JsonObject k2 = (JsonObject) k1.get(str);
				int key = k2.get("key").getAsInt();				
				String name = k2.get("id").getAsString();				
				map.put(key, name); 
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map; // Key, 챔프 이름
	}
	
	@Override
	public SummonerDTO getSummoner(String searchId) {
		 
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+searchId+"?api_key="+API_KEY;
		BufferedReader br = null;
		SummonerDTO summonerDTO = null;
		
		try {			
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) {
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			 
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			String accountId = k.get("accountId").getAsString();
			summonerDTO = new SummonerDTO(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return summonerDTO;
	}

	@Override
	public LeagueEntryDTO getLeagueEntry(String id) {
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key="+API_KEY;
		BufferedReader br = null;
		LeagueEntryDTO leagueEntryDTO = null;
		
		try {			
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line = "";
			while((line = br.readLine()) != null) {
				result = result + line;
			}
			
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			JsonObject k = (JsonObject) arr.get(0);

			String leagueId = k.get("leagueId").getAsString();
			String summonerId = k.get("summonerId").getAsString(); 
			String summonerName = k.get("summonerName").getAsString();
			String queueType = k.get("queueType").getAsString();
			String tier = k.get("tier").getAsString(); 
			String rank = k.get("rank").getAsString();
			int leaguePoints = k.get("leaguePoints").getAsInt();
			int wins = k.get("wins").getAsInt();
			int losses = k.get("losses").getAsInt();
			
			leagueEntryDTO = new LeagueEntryDTO(leagueId, summonerId, summonerName, queueType, tier, rank, leaguePoints, wins, losses); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return leagueEntryDTO;
	}

	@Override
	public ChampionInfoDTO getChapionInfo() {
		String urlStr = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key="+API_KEY;
		BufferedReader br = null;
		ChampionInfoDTO championInfoDTO = null;
		
		try {			
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line = "";
			while((line = br.readLine()) != null) {
				result = result + line;
			}
			
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			
			int maxNewPlayerLevel = k.get("maxNewPlayerLevel").getAsInt();
			JsonElement element1 = k.getAsJsonArray("freeChampionIdsForNewPlayers");
			List<Integer> freeChampionIdsForNewPlayers = new ArrayList<Integer>();
			  

			String str1 = element1 +"";
			str1 = str1.substring(1,str1.length()-1);
			
			String[] num = str1.split(",");  
			for(String i : num) {
				freeChampionIdsForNewPlayers.add(Integer.parseInt(i));
			}
			
			JsonElement element2 = k.getAsJsonArray("freeChampionIds");
			List<Integer> freeChampionIds = new ArrayList<Integer>();
			String str2 = element2 +"";
			str2 = str2.substring(1,str2.length()-1);
			
			String[] num2 = str2.split(","); 
			for(String i : num2) {
				freeChampionIds.add(Integer.parseInt(i));
			}
			championInfoDTO = new ChampionInfoDTO(maxNewPlayerLevel, freeChampionIdsForNewPlayers, freeChampionIds);
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return championInfoDTO;
	}

	@Override
	public List<String> getImgName(ChampionInfoDTO championInfoDTO, HashMap<Integer, String> map) {
		
		List<String> imgName = new ArrayList<String>();		
		List<Integer> list = championInfoDTO.getFreeChampionIds();
		
		for(int i : list) {				
			String name = map.get(i);			
			imgName.add(name);			
		}			
		
		return imgName;
	}

	@Override
	public MatchlistDTO getMatchList(String accountId, HashMap<Integer, String> map) {
		String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+accountId+"?endIndex=20&api_key="+API_KEY;
		BufferedReader br = null;
		MatchlistDTO matchListDTO = new MatchlistDTO();
		List<MatchReferenceDTO> matchReferenceDTOList = new ArrayList<MatchReferenceDTO>();
		
		try {			 
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			JsonArray matches = (JsonArray) k.get("matches");
			
			for(int i=0; i<matches.size(); i++) {
				JsonObject matchObject = (JsonObject) matches.get(i);
				
				String platformId = matchObject.get("platformId").getAsString();
				long gameId = matchObject.get("gameId").getAsLong();
				int champion = matchObject.get("champion").getAsInt();
				String championName = map.get(champion);
				int queue = matchObject.get("queue").getAsInt();
				int season = matchObject.get("season").getAsInt();
				long timestamp = matchObject.get("timestamp").getAsLong();
				String role = matchObject.get("role").getAsString();
				String lane = matchObject.get("lane").getAsString();

				HashMap<String, String> matchInfo = matchWin(gameId, champion);
				
				MatchReferenceDTO matchReferenceDTO = new MatchReferenceDTO(
						gameId, role, season, platformId, champion, championName, queue, lane, timestamp, matchInfo.get("win"), matchInfo.get("kills"), matchInfo.get("assists"), matchInfo.get("deaths"));
				matchReferenceDTOList.add(matchReferenceDTO);
								
			}			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		matchListDTO.setMatches(matchReferenceDTOList); 
		return matchListDTO;		
	}

	private HashMap<String, String> matchWin(long gameId, int champion) {
		String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+gameId+"?api_key="+API_KEY;
		HashMap<String, String> map = new HashMap<String, String>();
		String win = "";
		String kills = "";
		String deaths = "";
		String assists = "";
		BufferedReader br = null;
		SummonerDTO summonerDTO = null;
		
		try {			
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) {
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			JsonArray arr = k.getAsJsonArray("participants");
			
			for(int i=0; i<arr.size(); i++) {
				JsonObject data = (JsonObject) arr.get(i);
				if(data.get("championId").getAsInt() == champion) {
					
		 			JsonObject stats = (JsonObject) data.get("stats");
					win = stats.get("win").getAsString();
					kills = stats.get("kills").getAsInt() +"";
					deaths = stats.get("deaths").getAsInt() +"";
					assists = stats.get("assists").getAsInt() +""; 
					
					map.put("win", win);
					map.put("kills", kills);
					map.put("deaths", deaths);
					map.put("assists", assists);
				}				 
			} 			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return map;
	}
}
