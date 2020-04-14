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
	
	ProductRepository productRepository;
	OrderRepository orderRepository;
	QuizRepository quizRepository;
	QuestionRepository questionRepository;
	AnswerRepository answerRepository;
	
	
	@Autowired
	public CRUDController(ProductRepository productRepository,
						  OrderRepository orderRepository,
						  QuizRepository quizRepository,
						  QuestionRepository questionRepository,
						  AnswerRepository answerRepository) {
		this.productRepository = productRepository;
		this.orderRepository= orderRepository;
		this.quizRepository = quizRepository;
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productRepository.findAll());
	}
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok(orderRepository.findAll());
	}
	
	@GetMapping("/products/{name}")
	public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable ("name") String productName){
		return ResponseEntity.ok(productRepository.findByName(productName));
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Optional<Order>> getAllProductsByName(@PathVariable ("id") Long id){
		return ResponseEntity.ok(orderRepository.findById(id));
	}
	
	@PostMapping(path = "/products" , consumes = "application/json")
	public ResponseEntity<HttpStatus> saveProduct(@RequestBody Product product){
		productRepository.save(product);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/orders" , consumes = "application/json")
	public ResponseEntity<HttpStatus> saveOrder(@RequestBody Order order){
		orderRepository.save(order);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{name}")
	public ResponseEntity<HttpStatus> deleteProductByName(@PathVariable ("name") String productName){
		productRepository.deleteAll(productRepository.findByName(productName));
		return ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}

	//Quiz App End Points
	@GetMapping("/quizApp/quizzes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Quiz>> getAllQuizzes(){
		return ResponseEntity.ok(quizRepository.findAll());
	}

	@GetMapping("/quizApp/questions")
	@CrossOrigin(origins = "http://localhost:4200/")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return ResponseEntity.ok(questionRepository.findAll());
	}

	@GetMapping("/quizApp/answers")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Answer>> getAllAnswers(){
		return ResponseEntity.ok(answerRepository.findAll());
	}


	@GetMapping("/quizApp/quiz/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Optional<Quiz>> getQuizById(@PathVariable long id){
		return ResponseEntity.ok(quizRepository.findById(id));
	}

	@GetMapping("/quizApp/question/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable long id){
		return ResponseEntity.ok(questionRepository.findById(id));
	}

	@GetMapping("/quizApp/answer/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Optional<Answer>> getAnswerById(@PathVariable long id){
		return ResponseEntity.ok(answerRepository.findById(id));
	}

	@PostMapping(path = "/quizApp/addQuestion" , consumes = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> saveQuestion(@RequestBody Question question){
		question.setAnswerQuestion();
		questionRepository.save(question);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@PostMapping(path = "/quizApp/addAnswers" , consumes = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> saveQuestion(@RequestBody Set<Answer> answers){
		answerRepository.saveAll(answers);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}


}

