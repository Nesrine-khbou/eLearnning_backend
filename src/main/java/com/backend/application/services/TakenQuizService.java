package com.backend.application.services;

import com.backend.application.entities.TakenQuiz;
import com.backend.application.repositories.TakenQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenQuizService {

    @Autowired
    private TakenQuizRepository takenQuizRepository;

    public TakenQuiz addTakenQuiz(TakenQuiz takenQuiz) {
        // Save the taken quiz to the database
        return takenQuizRepository.save(takenQuiz);
    }

    public List<TakenQuiz> getQuizzesByStudentId(Long studentId) {
        return takenQuizRepository.findByStudentId(studentId);
    }

    public List<TakenQuiz> getStudentsByQuizId(Long quizId) {
        return takenQuizRepository.findByQuizId(quizId);
    }
}
