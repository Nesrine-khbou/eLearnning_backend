package com.backend.application.controllers;

import com.backend.application.entities.Review;
import com.backend.application.entities.Course;
import com.backend.application.entities.Student;
import com.backend.application.services.ReviewService;
import com.backend.application.services.CourseService;
import com.backend.application.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final CourseService courseService;
    private final StudentService studentService;

    // Constructor injection
    public ReviewController(ReviewService reviewService, CourseService courseService, StudentService studentService) {
        this.reviewService = reviewService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping
    public Review createReview(@RequestBody Review reviewRequest) {
        System.out.println("Review received: " + reviewRequest.toString());
        // Retrieve Course and Student entities using the ids provided in the request body
        Course course = courseService.getCourseById(reviewRequest.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + reviewRequest.getCourse().getId()));

        Student student = studentService.getStudentById(reviewRequest.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + reviewRequest.getStudent().getId()));

        // Set the Course and Student to the Review object
        reviewRequest.setCourse(course);
        reviewRequest.setStudent(student);

        // Save and return the Review
        return reviewService.saveReview(reviewRequest);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        System.out.println("Get all reviews");
        return reviewService.getAllReviews();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
