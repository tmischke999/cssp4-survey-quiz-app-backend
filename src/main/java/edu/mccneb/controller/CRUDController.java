package edu.mccneb.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import edu.mccneb.model.*;
import edu.mccneb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CRUDController {

    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;


    @Autowired
    public CRUDController(
            QuizRepository quizRepository,
            QuestionRepository questionRepository,
            AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    //Quiz App End Points
    @GetMapping("/quizApp/quizzes")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizRepository.findAll());
    }

    @GetMapping("/quizApp/questions")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @GetMapping("/quizApp/answers")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return ResponseEntity.ok(answerRepository.findAll());
    }


    @GetMapping("/quizApp/quiz/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Quiz>> getQuizById(@PathVariable long id) {
        return ResponseEntity.ok(quizRepository.findById(id));
    }

    @GetMapping("/quizApp/question/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable long id) {
        return ResponseEntity.ok(questionRepository.findById(id));
    }

    @GetMapping("/quizApp/answer/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Answer>> getAnswerById(@PathVariable long id) {
        return ResponseEntity.ok(answerRepository.findById(id));
    }

    @PostMapping(path = "/quizApp/addQuestion", consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<HttpStatus> saveQuestion(@RequestBody Question question) {
        question.setAnswerQuestion();
        questionRepository.save(question);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/quizApp/addAnswers", consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<HttpStatus> saveQuestion(@RequestBody Set<Answer> answers) {
        answerRepository.saveAll(answers);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}

