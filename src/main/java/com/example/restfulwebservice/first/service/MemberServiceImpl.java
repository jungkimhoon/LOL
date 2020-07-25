package com.example.restfulwebservice.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfulwebservice.first.dao.MemberDAO;
import com.example.restfulwebservice.first.dto.MemberDTO;

@Service(value="memberService")  
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> getInfo() {
		// TODO Auto-generated method stub
		return memberDAO.getInfo();
	}
	
}
