package com.example.restfulwebservice.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
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
}
