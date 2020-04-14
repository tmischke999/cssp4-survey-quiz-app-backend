package edu.mccneb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Question{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "question_quiz", joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private Set<Answer> answers;


    public Question() {
    }

    public Question(String content) {
        this.content = content;
    }


    public Question(String content, Set<Quiz> quizzes, Set<Answer> answers){
        this.content = content;
        this.quizzes = quizzes;
        this.answers = answers;
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


    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }


    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }


    public void setAnswerQuestion(){
        this.answers.forEach(answer -> answer.setQuestion(this));
    }

    @Override
    public String toString() {
        String result = String.format(
                "Question [id=%d, name='%s']%n",
                id, content);
        if (quizzes != null) {
            for(Quiz quiz : quizzes) {
                result += String.format(
                        "Quiz[id=%d, name='%s']%n",
                        quiz.getId(), quiz.getContent());
            }
        }

        return result;
    }
}

