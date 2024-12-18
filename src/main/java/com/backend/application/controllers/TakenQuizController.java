package com.backend.application.controllers;

import com.backend.application.entities.TakenQuiz;
import com.backend.application.services.TakenQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taken-quizzes")
public class TakenQuizController {

    @Autowired
    private TakenQuizService takenQuizService;

    // Add a new taken quiz
    @PostMapping
    public ResponseEntity<TakenQuiz> addTakenQuiz(@RequestBody TakenQuiz takenQuiz) {
        TakenQuiz savedTakenQuiz = takenQuizService.addTakenQuiz(takenQuiz);
        return ResponseEntity.ok(savedTakenQuiz);
    }

    // Get all quizzes taken by a specific student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TakenQuiz>> getQuizzesByStudent(@PathVariable Long studentId) {
        List<TakenQuiz> quizzes = takenQuizService.getQuizzesByStudentId(studentId);
        return ResponseEntity.ok(quizzes);
    }

    // Get all students who took a specific quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<TakenQuiz>> getStudentsByQuiz(@PathVariable Long quizId) {
        List<TakenQuiz> students = takenQuizService.getStudentsByQuizId(quizId);
        return ResponseEntity.ok(students);
    }
}
