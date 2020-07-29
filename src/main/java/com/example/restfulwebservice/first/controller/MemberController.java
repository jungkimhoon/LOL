package com.example.restfulwebservice.first.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(path = "/member/loginForm") 
	public String hello() { 
		return "/member/loginForm";   
	}  
	
	@RequestMapping(value="/member/loginForm", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("display", "../member/loginForm.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav;
	} 
	
	@RequestMapping(value="/member/signUpForm", method=RequestMethod.GET)
	public ModelAndView signUpForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("display", "../member/signUpForm.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav;
	} 
	
	@RequestMapping(value="/member/signUp", method=RequestMethod.POST)
	public ModelAndView signUp(@RequestParam HashMap<String, String> map) {
		ModelAndView mav = new ModelAndView(); 
		System.out.println(map.get("id"));
		
		mav.addObject("display", "../main/body.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav; 
	} 
}
