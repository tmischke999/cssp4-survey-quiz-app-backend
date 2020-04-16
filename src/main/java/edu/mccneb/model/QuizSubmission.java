package edu.mccneb.model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class QuizSubmission {
    private long id;
    private String content;
    private Set<QuestionSubmission> questionSubmissions;

    public QuizSubmission(){

    }

    public QuizSubmission(String content){
        this.content = content;
    }

    public QuizSubmission(String content, Set<QuestionSubmission> questionSubmissions){
        this.content = content;
        this.questionSubmissions = questionSubmissions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToMany(mappedBy = "quizSubmissions")
    public Set<QuestionSubmission> getQuestions() {
        return questionSubmissions;
    }

    public void setQuestions(Set<QuestionSubmission> questionSubmissions) {
        this.questionSubmissions = questionSubmissions;
    }

    @Override
    public String toString() {
        return "QuizSubmission [id=" + id + ", name=" + content + ", questionSubmissions=" + questionSubmissions + "]";
    }


}

