package com.example.restfulwebservice.first.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
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
import com.example.restfulwebservice.first.dto.Participants;
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
		String version = "10.15.1";
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
		try {
			searchId = URLEncoder.encode(searchId, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
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
	public List<LeagueEntryDTO> getLeagueEntry(String id) {
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key="+API_KEY;
		BufferedReader br = null;
		List<LeagueEntryDTO> list = new ArrayList<LeagueEntryDTO>();
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
			for(int i=0; i<arr.size(); i++) {				
				JsonObject k = (JsonObject) arr.get(i);
				
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
				list.add(leagueEntryDTO);
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
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
				List<Participants> participantsList = ParticipantsList(gameId);
				
				MatchReferenceDTO matchReferenceDTO = new MatchReferenceDTO(
						gameId, role, season, platformId, champion, championName, queue, lane, timestamp, matchInfo.get("gameDuration"),
						matchInfo.get("win"), matchInfo.get("kills"), matchInfo.get("assists"), matchInfo.get("deaths"),
						matchInfo.get("item0"), matchInfo.get("item1"), matchInfo.get("item2"), matchInfo.get("item3"), matchInfo.get("item4"), matchInfo.get("item5"), matchInfo.get("item6"),
						matchInfo.get("spell1Id"), matchInfo.get("spell2Id"), participantsList);
				
				matchReferenceDTOList.add(matchReferenceDTO); 
								
			}			 
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		
		matchListDTO.setMatches(matchReferenceDTOList); 
		return matchListDTO;		
	}

	private List<Participants> ParticipantsList(long gameId) {
		String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+gameId+"?api_key="+API_KEY;
		BufferedReader br = null;
		List<Participants> participantsList = new ArrayList<Participants>();
		HashMap<Integer, String> map = ChampIdToKey();
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
			JsonArray participantIdentities = (JsonArray) k.get("participantIdentities");
			JsonArray participant = k.getAsJsonArray("participants");
					 
			for(int i=0; i<participantIdentities.size(); i++) {
				JsonObject object = (JsonObject) participantIdentities.get(i);
				
				int participantId = object.get("participantId").getAsInt();
				JsonObject ChampionId = (JsonObject) participant.get(participantId-1);
				int champID = ChampionId.get("championId").getAsInt();
				
				String ChampName = map.get(champID);
				JsonObject ele = (JsonObject) object.get("player");
				String summonerName = ele.get("summonerName").getAsString();
				Participants participants = new Participants(participantId, summonerName, ChampName);
				participantsList.add(participants); 
			}
						
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participantsList;
	}

	public HashMap<String, String> matchWin(long gameId, int champion) {
		String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+gameId+"?api_key="+API_KEY;
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> spellMap = SpellKeyToName();
		
		String win = "";
		String kills = ""; 
		String deaths = "";
		String assists = "";
		
		String item0 = "";
		String item1 = "";
		String item2 = "";
		String item3 = "";
		String item4 = "";
		String item5 = "";
		String item6 = "";
		
		String spell1Id = "";
		String spell2Id = "";
		
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
			String gameDuration = k.get("gameDuration").getAsInt()+"";
			JsonArray arr = k.getAsJsonArray("participants");
			
			for(int i=0; i<arr.size(); i++) {
				JsonObject data = (JsonObject) arr.get(i);
				if(data.get("championId").getAsInt() == champion) {
					spell1Id = data.get("spell1Id").getAsInt() + "";
					spell2Id = data.get("spell2Id").getAsInt() + ""; 
					
		 			JsonObject stats = (JsonObject) data.get("stats");
					win = stats.get("win").getAsString();
					kills = stats.get("kills").getAsInt() +"";
					deaths = stats.get("deaths").getAsInt() +"";
					assists = stats.get("assists").getAsInt() +""; 
					
					item0 = stats.get("item0").getAsInt() +""; 
					item1 = stats.get("item1").getAsInt() +""; 
					item2 = stats.get("item2").getAsInt() +""; 
					item3 = stats.get("item3").getAsInt() +""; 
					item4 = stats.get("item4").getAsInt() +""; 
					item5 = stats.get("item5").getAsInt() +""; 
					item6 = stats.get("item6").getAsInt() +"";
					
					map.put("win", win);
					map.put("kills", kills);
					map.put("deaths", deaths);
					map.put("assists", assists);
					map.put("gameDuration", gameDuration);
					
					map.put("item0", item0);
					map.put("item1", item1);
					map.put("item2", item2);
					map.put("item3", item3);
					map.put("item4", item4);
					map.put("item5", item5);
					map.put("item6", item6);
					
					map.put("spell1Id", spellMap.get(spell1Id));
					map.put("spell2Id", spellMap.get(spell2Id));
					
				}				 
			} 			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return map; 
	}
	
	public HashMap<String, String> SpellKeyToName(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("1","SummonerBoost");
		map.put("3","SummonerExhaust");
		map.put("4","SummonerFlash");
		map.put("6","SummonerHaste");
		map.put("7","SummonerHeal"); 
		map.put("11","SummonerSmite");
		map.put("12","SummonerTeleport");
		map.put("13","SummonerMana");	 
		map.put("14","SummonerDot");
		map.put("21","SummonerBarrier");
		map.put("30","SummonerPoroRecall");
		map.put("31","SummonerPoroThrow");
		map.put("32","SummonerSnowball");
		map.put("39","SummonerSnowURFSnowball_Mark");
		 
		return map;
	}
}
