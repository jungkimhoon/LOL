package com.example.restfulwebservice.first.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.restfulwebservice.first.dto.BoardDTO;
import com.example.restfulwebservice.first.dto.BoardPaging;
import com.example.restfulwebservice.first.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardWriteForm", method=RequestMethod.GET)
	public ModelAndView boardWriteForm() {
		ModelAndView mav = new ModelAndView();	 
		
		mav.addObject("display", "../board/boardWriteForm.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav;
	}  
	
	@RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView boardWrite(@ModelAttribute BoardDTO boardDTO, @RequestParam MultipartFile boardFileRequest) {
		ModelAndView mav = new ModelAndView();	 
		String baseDir = "C:\\eclipse\\exam\\src\\main\\webapp\\storage";
		String name = boardFileRequest.getOriginalFilename();
		boardDTO.setBoardFile(name);
		
		System.out.println(boardDTO.getBoardFile());
		 
		try {
			boardFileRequest.transferTo(new File(baseDir+"\\"+boardFileRequest.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		boardService.boardWrite(boardDTO); 		
		 
		mav.addObject("display", "body.jsp"); 
		mav.setViewName("/main/main");	 	
		return mav;
	}  
	
	@RequestMapping(value="/board/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(required=false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();	
		BoardPaging boardPaging = boardService.boardPaging(pg);
		Map<String, String> map = new HashMap<String, String>();
		map.put("pg",pg);
		
		List<BoardDTO> boardList = boardService.boardList(map);		
		
		mav.addObject("pg", pg);
		mav.addObject("boardList", boardList);
		mav.addObject("boardPaging", boardPaging);
		mav.addObject("display", "../board/boardList.jsp");
		mav.setViewName("/main/main");	 	
		return mav;
	}  
	
	@RequestMapping(value="/board/boardView", method=RequestMethod.GET)
	public ModelAndView boardView(@RequestParam int seq) {
		ModelAndView mav = new ModelAndView();	
		  
		BoardDTO boardDTO = boardService.boardView(seq);		
		
		mav.addObject("display", "../board/boardView.jsp");
		mav.addObject("boardDTO", boardDTO);
		mav.setViewName("/main/main");	 	
		return mav;
	}  
	
	@RequestMapping(value="/board/boardListSearch", method=RequestMethod.GET)
	public ModelAndView boardList(@RequestParam Map<String, String> map) {
		//Map에 pg, searchOption, keyword 있음
		ModelAndView mav = new ModelAndView();	
		String pg = map.get("pg");
		BoardPaging boardPaging = boardService.boardSearchPaging(map);
		 
		map.put("pg",pg);
		
		List<BoardDTO> boardList = boardService.boardListSearch(map);		
		
		mav.addObject("pg", pg);
		mav.addObject("boardList", boardList);
		mav.addObject("boardPaging", boardPaging);
		mav.addObject("display", "../board/boardListSearch.jsp");
		mav.setViewName("/main/main");	 	
		return mav;
	}  
	
}
