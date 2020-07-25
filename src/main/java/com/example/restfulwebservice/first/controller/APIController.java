package com.example.restfulwebservice.first.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.boot.autoconfigure.elasticsearch.jest.HttpClientConfigBuilderCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.dto.SummonerDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class APIController {
	final static String API_KEY = "RGAPI-888dcde5-b392-40ed-ba14-4bd917b78132";
	
	@RequestMapping(value="/search/getSummoner", method=RequestMethod.POST)
	public ModelAndView getSummoner(@RequestParam String searchId) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", searchId);
		mav.addObject("display", "../search/getSummoner.jsp");
		mav.setViewName("/main/main"); 
		return mav;		
		
	} 	
	
	@RequestMapping(value="/search/searchSummoner", method=RequestMethod.GET)
	public ModelAndView searchSummoner(@RequestParam String searchId) {
		BufferedReader br = null;
		SummonerDTO summonerDTO = null; 
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+searchId+"?api_key="+API_KEY;
		 
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
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("summonerDTO", summonerDTO);
		mav.addObject("searchId", searchId);
		mav.addObject("display", "../search/searchSummoner.jsp");
		mav.setViewName("/main/main"); 
		return mav;		
		
	} 	
}
