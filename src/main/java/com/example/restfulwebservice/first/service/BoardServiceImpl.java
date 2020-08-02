package com.example.restfulwebservice.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfulwebservice.first.dao.BoardDAO;
import com.example.restfulwebservice.first.dto.BoardDTO;
import com.example.restfulwebservice.first.dto.BoardPaging;

@Service(value="boardService")  
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private BoardPaging boardPaging;
	
	@Override
	public void boardWrite(BoardDTO boardDTO) {
		boardDAO.boardWrite(boardDTO);
		
	}

	@Override
	public List<BoardDTO> boardList(Map<String, String> map) {
		
		int endNum = Integer.parseInt(map.get("pg"))*6;
		int startNum = endNum-5;   		
		 
		map.put("startNum", startNum+""); 
		map.put("endNum", endNum+"");
		
		return boardDAO.boardList(map);
	}

	@Override 
	public BoardDTO boardView(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.boardView(seq);
	}

	@Override
	public BoardPaging boardPaging(String pg) {
		int totalA = boardDAO.boardListTotalA();
		
		boardPaging.setCurrentPage(Integer.parseInt(pg)); 
		boardPaging.setPageBlock(5);
		boardPaging.setPageSize(6);  
		boardPaging.setTotalA(totalA); 
		boardPaging.makeSearchPagingHTML();   
		 
		return boardPaging; 
	}

	@Override
	public BoardPaging boardSearchPaging(Map<String, String> map) {
		
		int totalA = boardDAO.boardSearchTotalA(map);//총글수
		
		boardPaging.setCurrentPage(Integer.parseInt(map.get("pg"))); 
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(8);    
		boardPaging.makeSearchPagingHTML();   
		return boardPaging; 
	}

	@Override
	public List<BoardDTO> boardListSearch(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("pg"))*8;
		int startNum = endNum-7; 
		 
		map.put("startNum", startNum+""); 
		map.put("endNum", endNum+"");  
		
		List<BoardDTO> list = boardDAO.boardListSearch(map);
		return list;
	} 

} 
