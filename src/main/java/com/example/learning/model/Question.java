package com.example.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pertanyaan")
public class Question {
	@Id
	@GeneratedValue(generator = "pertanyaan_generator")
	@SequenceGenerator(name = "pertanyaan_generator", sequenceName = "pertanyaan_generator", initialValue = 1)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String title;
	
	@Column(columnDefinition = "text")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
