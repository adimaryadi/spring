package com.example.learning.utility;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.learning.jpa.JpaQuestion;
import com.example.learning.model.Question;

import antlr.collections.List;

public class Utility {
	
	@Autowired
	private JpaQuestion questionJpa;
	public Map<Long, String> MappingData() {
		java.util.List<Question> result = questionJpa.findAll();
		Map<Long,String> map = null;
//		if (result != null) {
//			map 	=   new HashMap<Long, String>();
//			for (Object[] object : result) {
//				map.put((Long)object[0],(String) object[1]);
//			}
//		}
		System.out.println(result);
		return map;
	}
}
