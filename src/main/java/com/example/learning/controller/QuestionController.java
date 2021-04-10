package com.example.learning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.example.learning.jpa.JpaQuestion;
import com.example.learning.model.Question;
import com.example.learning.utility.Utility;

import antlr.collections.List;
import exception.ResourceException;
@RestController
public class QuestionController {
	
	Utility util   	  =  new Utility();
	
	@Autowired
	View view;
	
	@Autowired
	private JpaQuestion questionJpa;
	
	@GetMapping("/pertanyaan")
	public Page<Question> getQuestion(Pageable pageable) {
		
		return questionJpa.findAll(pageable);
	}
	
	@RequestMapping(value = "/mvc", method = RequestMethod.GET)
	private ModelAndView getMvcQuestion() {
		ModelAndView result  =   new ModelAndView(view);
		result.addObject("data", "Tester");
		
		return result;
	}
	
	@PostMapping("/pertanyaan")
	public Question createQuestion(@Valid @RequestBody Question question) {
		return questionJpa.save(question);
	}
	
	@PutMapping("/pertanyaan/{id}")
	public Question updateQuestion(@PathVariable Long id, @Valid @RequestBody Question questionRequest) {
		return questionJpa.findById(id)
						  .map(question -> {
							  question.setTitle(questionRequest.getTitle());
							  question.setDescription(questionRequest.getDescription());
							  return questionJpa.save(question);
						  })
						  .orElseThrow(() -> {
							  return new ResourceException("Tidak ditemukan id = "+ id);
						  });
	}
	
	@DeleteMapping("/pertanyaan/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
		return questionJpa.findById(id)
				 	 	  .map(question -> {
				 	 		 questionJpa.delete(question);
				 	 		 return ResponseEntity.ok().build();
				 	 	  })
				 	 	  .orElseThrow(() -> new ResourceException("Tidak ditemnukan id = "+id));
	}
}