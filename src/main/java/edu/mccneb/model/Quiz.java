package edu.mccneb.model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Quiz {
    private Long id;
    private String content;
    private Set<Question> questions;

    public Quiz(){

    }

    public Quiz(String content){
        this.content = content;
    }

    public Quiz(String content, Set<Question> questions){
        this.content = content;
        this.questions = questions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToMany(mappedBy = "quizzes")
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", name=" + content + ", questions=" + questions + "]";
	}
    
    
}

