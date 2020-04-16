package edu.mccneb;

import edu.mccneb.model.Answer;
import edu.mccneb.repository.AnswerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mccneb.model.Question;
import edu.mccneb.model.Quiz;
import edu.mccneb.repository.QuestionRepository;
import edu.mccneb.repository.QuizRepository;

import javax.transaction.Transactional;
import java.util.HashSet;

@SpringBootApplication
public class QuestionQuizApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(QuestionQuizApplication.class);

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuestionQuizApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of Quizzes
        Quiz quizA = new Quiz("Quiz A");
//        quizA.setId(1);
        Quiz quizB = new Quiz("Quiz B");
//        quizB.setId(2);
        Quiz quizC = new Quiz("Quiz C");
//        quizC.setId(3);


        //question A added to Quiz A and 
        //question B added Quiz B
        questionRepository.saveAll(new HashSet<Question>(){{
            add(new Question("Question A", new HashSet<Quiz>(){{
                add(quizA);
                add(quizB);
            }},new HashSet<Answer>(){{
                add(new Answer("Answer A1 F",false));
                add(new Answer("Answer A2 T",true));
                add(new Answer("Answer A3 F",false));
            }}));

            add(new Question("Question B", new HashSet<Quiz>(){{
                add(quizA);
                add(quizC);
            }},new HashSet<Answer>(){{
                add(new Answer("Answer B1 F",false));
                add(new Answer("Answer B2 T",true));
                add(new Answer("Answer B3 F",false));
            }}));
        }});




        // fetch all questions
        for(Question question : questionRepository.findAll()) {
            logger.info(question.toString());
        }
        
        //add a new question to an existing quiz. 
        questionRepository.saveAll(new HashSet<Question>(){{
            add(new Question("Question C", new HashSet<Quiz>(){{
                add(quizA);
            }},new HashSet<Answer>(){{
                add(new Answer("Answer C1 F",false));
                add(new Answer("Answer C2 T",true));
                add(new Answer("Answer C3 F",false));
            }}));
        }});
        
        //add existing question to an existing quiz for e.g. add "question c" to "quiz b"
        Question qc = questionRepository.findByContent("Question C").get();
        qc.getQuizzes().add(quizB);
        questionRepository.save(qc);

//        Quiz quiz1 = quizRepository.findById((long) 1).get();
//        Question quest1 = new Question("Question C", new HashSet<Quiz>(){{
//            add(quiz1);
//        }},new HashSet<Answer>(){{
//            add(new Answer("A1 F",false));
//            add(new Answer("A2 T",true));
//            add(new Answer("A3 F",false));
//        }});
//        questionRepository.save(quest1);
    }
}

