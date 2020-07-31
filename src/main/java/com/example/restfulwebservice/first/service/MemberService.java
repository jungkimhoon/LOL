package com.example.restfulwebservice.first.service;

import java.util.HashMap;
import java.util.List;
import com.example.restfulwebservice.first.dto.MemberDTO;

public interface MemberService {

	public List<MemberDTO> getInfo();

	public void signUp(HashMap<String, String> map);

	public MemberDTO login(HashMap<String, String> map);  
  
}
  