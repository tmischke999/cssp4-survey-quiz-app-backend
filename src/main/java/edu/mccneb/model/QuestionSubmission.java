package edu.mccneb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

@Entity
public class QuestionSubmission{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "questionSubmission_quizSubmission", joinColumns = @JoinColumn(name = "questionSubmission_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "quizSubmission_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<QuizSubmission> quizSubmissions;

    @OneToMany(mappedBy = "questionSubmission", cascade = CascadeType.ALL)
    private Set<AnswerSubmission> answerSubmissions;

    public QuestionSubmission() {
    }

    public QuestionSubmission(String content) {
        this.content = content;
    }


    public QuestionSubmission(String content, Set<QuizSubmission> quizSubmissions, Set<AnswerSubmission> answerSubmissions){
        this.content = content;
        this.quizSubmissions = quizSubmissions;
        this.answerSubmissions = answerSubmissions;
        setAnswerQuestion();
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


    public Set<AnswerSubmission> getAnswerSubmissions() {
        return answerSubmissions;
    }

    public void setAnswers(Set<AnswerSubmission> answerSubmissions) {
        this.answerSubmissions = answerSubmissions;
    }


    public Set<QuizSubmission> getQuizSubmissions() {
        return quizSubmissions;
    }

    public void setQuizzes(Set<QuizSubmission> quizSubmissions) {
        this.quizSubmissions = quizSubmissions;
    }


    public void setAnswerQuestion(){
        this.answerSubmissions.forEach(answerSubmission -> answerSubmission.setQuestionSubmission(this));
    }

    @Override
    public String toString() {
        String result = String.format(
                "QuestionSubmission [id=%d, name='%s']%n",
                id, content);
        if (quizSubmissions != null) {
            for(QuizSubmission quiz : quizSubmissions) {
                result += String.format(
                        "QuizSubmission[id=%d, name='%s']%n",
                        quiz.getId(), quiz.getContent());
            }
        }

        return result;
    }
}

