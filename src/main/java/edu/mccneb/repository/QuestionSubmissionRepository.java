package edu.mccneb.repository;

import edu.mccneb.model.Question;
import edu.mccneb.model.QuestionSubmission;
import edu.mccneb.model.Quiz;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSubmissionRepository extends JpaRepository<QuestionSubmission, Long>{
    public Optional<QuestionSubmission> findByContent(String content);
}

