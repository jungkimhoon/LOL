package com.example.restfulwebservice.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChampionIdToKeyDTO {
	private int key;
	private String id;
	private String name;
}
 