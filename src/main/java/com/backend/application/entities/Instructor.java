package com.backend.application.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nbReviews;
    private int nbStudents;
    private int nbCourses;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbReviews() {
        return nbReviews;
    }

    public void setNbReviews(int nbReviews) {
        this.nbReviews = nbReviews;
    }

    public int getNbStudents() {
        return nbStudents;
    }

    public void setNbStudents(int nbStudents) {
        this.nbStudents = nbStudents;
    }

    public int getNbCourses() {
        return nbCourses;
    }

    public void setNbCourses(int nbCourses) {
        this.nbCourses = nbCourses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
