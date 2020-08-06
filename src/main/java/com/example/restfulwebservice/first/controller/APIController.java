package com.example.restfulwebservice.first.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.jest.HttpClientConfigBuilderCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.dto.LeagueEntryDTO;
import com.example.restfulwebservice.first.dto.MatchReferenceDTO;
import com.example.restfulwebservice.first.dto.MatchlistDTO;
import com.example.restfulwebservice.first.dto.SummonerDTO;
import com.example.restfulwebservice.first.service.APIService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class APIController {
	final static String API_KEY = "RGAPI-888dcde5-b392-40ed-ba14-4bd917b78132";
	
	@Autowired
	private APIService apiService;
	
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
		
		HashMap<Integer, String> map = apiService.ChampIdToKey();
		System.out.println(searchId); 
		SummonerDTO summonerDTO = apiService.getSummoner(searchId);	
		List<LeagueEntryDTO> leagueEntryDTOList = apiService.getLeagueEntry(summonerDTO.getId());
		MatchlistDTO matchlistDTO = apiService.getMatchList(summonerDTO.getAccountId(), map);
				 
		ModelAndView mav = new ModelAndView();		 
		mav.addObject("summonerDTO", summonerDTO); 
		mav.addObject("leagueEntryDTOList", leagueEntryDTOList);
		mav.addObject("matchlistDTO",matchlistDTO);
		mav.addObject("searchId", searchId);  
		mav.addObject("display", "../search/searchSummoner.jsp"); 
		mav.setViewName("/main/main"); 
		return mav;				
	} 		 
}
