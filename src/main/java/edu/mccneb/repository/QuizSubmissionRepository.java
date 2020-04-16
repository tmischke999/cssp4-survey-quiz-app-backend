package edu.mccneb.repository;

import java.util.Optional;

import edu.mccneb.model.QuizSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.mccneb.model.Quiz;

public interface QuizSubmissionRepository extends JpaRepository<QuizSubmission, Long>{

    public Optional<QuizSubmission> findByContent(String content);
}
