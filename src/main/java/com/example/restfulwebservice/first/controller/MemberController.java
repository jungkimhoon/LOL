package com.example.restfulwebservice.first.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.dto.MemberDTO;
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
		memberService.signUp(map);
		
		mav.addObject("display", "../main/body.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav; 
	} 
	
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam HashMap<String, String> map, HttpSession session) {  
		ModelAndView mav = new ModelAndView(); 
		MemberDTO memberDTO = memberService.login(map); 
			
			
		if(memberDTO != null) {
			mav.addObject("login", memberDTO.getId()); 
			session.setAttribute("memberId", memberDTO.getId()); 
		}else mav.addObject("login", "fail");  
		 	
		mav.setViewName("jsonView");	 	
		return mav; 
	} 
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {  	 
		ModelAndView mav = new ModelAndView(); 
		
		session.invalidate();
		 	
		mav.addObject("display", "../main/body.jsp"); 
		mav.setViewName("/main/main");	 	 	
		return mav; 
	} 
}
