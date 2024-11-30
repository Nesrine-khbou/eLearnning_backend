package com.backend.application.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_details")
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int nbStudents;

    @ElementCollection
    private List<String> learningSteps;

    @OneToOne(mappedBy = "courseDetails")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_content_id", referencedColumnName = "id")
    private CourseContent courseContent;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNbStudents() {
        return nbStudents;
    }

    public void setNbStudents(int nbStudents) {
        this.nbStudents = nbStudents;
    }

    public List<String> getLearningSteps() {
        return learningSteps;
    }

    public void setLearningSteps(List<String> learningSteps) {
        this.learningSteps = learningSteps;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseContent getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(CourseContent courseContent) {
        this.courseContent = courseContent;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
