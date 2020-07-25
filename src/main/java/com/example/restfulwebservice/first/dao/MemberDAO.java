package com.example.restfulwebservice.first.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.restfulwebservice.first.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	List<MemberDTO> getInfo();
}
 