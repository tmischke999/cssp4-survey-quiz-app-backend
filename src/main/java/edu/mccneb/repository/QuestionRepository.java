package edu.mccneb.repository;

import edu.mccneb.model.Question;
import edu.mccneb.model.Quiz;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	public Optional<Question> findByContent(String content);
}

