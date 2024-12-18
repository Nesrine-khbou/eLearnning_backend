package com.backend.application.controllers;

import com.backend.application.entities.Quiz;
import com.backend.application.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access the API
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    // Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Add a new quiz
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get a quiz by ID
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    // Update a quiz
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quizDetails) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));

        quiz.setType(quizDetails.getType());
        quiz.setTitle(quizDetails.getTitle());
        quiz.setDetails(quizDetails.getDetails());
        quiz.setLink(quizDetails.getLink());

        return quizRepository.save(quiz);
    }

    // Delete a quiz
    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizRepository.deleteById(id);
        return "Quiz deleted successfully!";
    }
}
