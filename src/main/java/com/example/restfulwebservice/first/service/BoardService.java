package com.example.restfulwebservice.first.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restfulwebservice.first.dto.BoardDTO;
import com.example.restfulwebservice.first.dto.BoardPaging;

public interface BoardService {

	public void boardWrite(BoardDTO boardDTO);

	public List<BoardDTO> boardList(Map<String, String> map);

	public BoardDTO boardView(int seq);

	public BoardPaging boardPaging(String pg);

	public BoardPaging boardSearchPaging(Map<String, String> map);

	public List<BoardDTO> boardListSearch(Map<String, String> map);
 
	public void boardModify(HashMap<String, String> map);

	public void boardDelete(String seq);  
  
	  
}
   