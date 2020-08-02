package com.example.restfulwebservice.first.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.restfulwebservice.first.dto.BoardDTO;

@Mapper 
public interface BoardDAO {

	public void boardWrite(BoardDTO boardDTO); 

	public List<BoardDTO> boardList(Map<String, String> map);

	public BoardDTO boardView(int seq); 

	public int boardListTotalA();

	public int boardSearchTotalA(Map<String, String> map);

	public List<BoardDTO> boardListSearch(Map<String, String> map);  
  
}
 