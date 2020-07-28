package com.example.restfulwebservice.first.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.dto.ChampionInfoDTO;
import com.example.restfulwebservice.first.dto.MemberDTO;
import com.example.restfulwebservice.first.service.APIService;
import com.example.restfulwebservice.first.service.MemberService;

@Controller 
public class FirstController {
	@Autowired
	MemberService memberService;	
	@Autowired
	private APIService apiService;
	
	@RequestMapping(path = "/welcome")
	public String welcome() { 
		return "welcome"; 
	}  
	
	@RequestMapping(value="/main/main", method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();	
		HashMap<Integer, String> map = apiService.ChampIdToKey();
		
		ChampionInfoDTO championInfoDTO = apiService.getChapionInfo(); 
		List<String> imgName = apiService.getImgName(championInfoDTO, map);
		
		mav.addObject("display", "body.jsp");
		mav.addObject("championInfoDTO", championInfoDTO);
		mav.addObject("imgName", imgName);
		mav.setViewName("/main/main");	 	
		return mav;
	} 
	
	@RequestMapping(value="/main/member")
	public ModelAndView Member() {
		ModelAndView mav = new ModelAndView();
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list = memberService.getInfo();
		
		mav.addObject("display", "member.jsp");
		mav.addObject("list", list);
		mav.setViewName("/main/main"); 
		return mav;
	}	
	
}   
  