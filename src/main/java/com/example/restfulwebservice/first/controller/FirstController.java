package com.example.restfulwebservice.first.controller;

import java.util.ArrayList;
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

import com.example.restfulwebservice.first.dto.MemberDTO;
import com.example.restfulwebservice.first.service.MemberService;

@Controller 
public class FirstController {
	@Autowired
	MemberService memberService;	
	
	@RequestMapping(path = "/welcome")
	public String welcome() { 
		return "welcome"; 
	} 
	
	
	@RequestMapping(path = "/hello") 
	public String hello() { 
		return "hello";   
	} 
	
	@RequestMapping(value="/main/main", method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("display", "body.jsp");
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
  