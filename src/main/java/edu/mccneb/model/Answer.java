package edu.mccneb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Answer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;



//    @Column(name = "question_id", insertable = false, updatable = false)
//    private int questionId;

    public Answer() {

    }

    public Answer(String content) {
        this.content = content;
    }

    public Answer(String content, boolean isCorrect) {
        this.isCorrect = isCorrect;
        this.content = content;
    }


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

    @JsonProperty(value = "isCorrect")
    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }



    @Override
    public String toString() {
        String result = String.format("Answer [id=%d, name='%s']%n", id, content);
//        if (question != null) {
//            result += String.format("Question[id=%d, name='%s']%n", question.getId(), question.getName());
//        }

        return result;
    }
}

