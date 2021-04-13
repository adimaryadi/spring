package com.example.learning.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TesterMvcController {
	
	@GetMapping("/test")
	public Map<String, String> tester() {
		HashMap<String, String> map = new HashMap<>();
		map.put("nama", "Adimaryadi");
		map.put("alamat", "Kp cisaroni RW 07 RT08");
		return map;
	}

}
