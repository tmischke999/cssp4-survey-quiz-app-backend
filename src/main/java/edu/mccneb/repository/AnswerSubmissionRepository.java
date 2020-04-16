package edu.mccneb.repository;

import edu.mccneb.model.Answer;
import edu.mccneb.model.AnswerSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerSubmissionRepository extends JpaRepository<AnswerSubmission, Long> {
}
