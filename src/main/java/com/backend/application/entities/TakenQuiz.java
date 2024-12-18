package com.backend.application.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "taken_quiz")
public class TakenQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long studentId; // ID of the student who took the quiz

    @Column(nullable = false)
    private Long quizId; // ID of the quiz taken

    // Default Constructor
    public TakenQuiz() {}

    // Parameterized Constructor
    public TakenQuiz(Long studentId, Long quizId) {
        this.studentId = studentId;
        this.quizId = quizId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    // toString Method
    @Override
    public String toString() {
        return "TakenQuiz{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", quizId=" + quizId +
                '}';
    }
}
