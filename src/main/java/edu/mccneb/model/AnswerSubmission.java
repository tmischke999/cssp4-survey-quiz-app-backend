package edu.mccneb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class AnswerSubmission{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private boolean isCorrect;
    private boolean isSelected;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private QuestionSubmission questionSubmission;

    public AnswerSubmission() {

    }

    public AnswerSubmission(String content) {
        this.content = content;
    }

    public AnswerSubmission(String content, boolean isCorrect) {
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

    public QuestionSubmission getQuestionSubmission() {
        return questionSubmission;
    }

    public void setQuestionSubmission(QuestionSubmission questionSubmission) {
        this.questionSubmission = questionSubmission;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }



    @Override
    public String toString() {
        String result = String.format("AnswerSubmission [id=%d, name='%s']%n", id, content);
//        if (questionSubmission != null) {
//            result += String.format("QuestionSubmission[id=%d, name='%s']%n", questionSubmission.getId(), questionSubmission.getName());
//        }

        return result;
    }
}

