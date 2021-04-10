package com.example.learning.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learning.model.Question;

import antlr.collections.List;

@Repository
public interface JpaQuestion extends JpaRepository<Question, Long> {
}
