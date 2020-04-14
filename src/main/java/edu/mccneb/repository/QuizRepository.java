package edu.mccneb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mccneb.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public Optional<Quiz> findByContent(String content);
}
