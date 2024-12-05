package com.backend.application.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@Entity
@Table(name = "students")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student extends User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private List<Enrollment> enrollments;

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private List<Review> reviews;

        // Getters and Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public List<Enrollment> getEnrollments() {
                return enrollments;
        }

        public void setEnrollments(List<Enrollment> enrollments) {
                this.enrollments = enrollments;
        }

        public List<Review> getReviews() {
                return reviews;
        }

        public void setReviews(List<Review> reviews) {
                this.reviews = reviews;
        }
}
