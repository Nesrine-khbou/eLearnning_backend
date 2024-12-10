package com.backend.application.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User {

    private double instructorRating; // Average rating for instructors
    private int totalStudents; // Total students enrolled in all instructor's courses
    private int totalReviews; // Total reviews for the instructor

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // Prevents infinite recursion during serialization
    private List<Course> courses;

    // New fields
    private String description; // Description of the instructor
    private String headline;    // Headline for the instructor

    // Getters and Setters
    public double getInstructorRating() {
        return instructorRating;
    }

    public void setInstructorRating(double instructorRating) {
        this.instructorRating = instructorRating;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for headline
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
