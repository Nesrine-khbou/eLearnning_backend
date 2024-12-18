package com.backend.application.repositories;
import com.backend.application.entities.TakenQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakenQuizRepository extends JpaRepository<TakenQuiz, Long> {
    List<TakenQuiz> findByStudentId(Long studentId); // Fetch quizzes taken by a specific student
    List<TakenQuiz> findByQuizId(Long quizId); // Fetch all students who took a specific quiz
}
