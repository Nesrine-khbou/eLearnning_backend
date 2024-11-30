package com.backend.application.controllers;

import com.backend.application.entities.CourseDetails;
import com.backend.application.services.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-details")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsService courseDetailsService;

    // Get all course details
    @GetMapping
    public List<CourseDetails> getAllCourseDetails() {
        return courseDetailsService.getAllCourseDetails();
    }

    // Get course details by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseDetails> getCourseDetailsById(@PathVariable Long id) {
        return courseDetailsService.getCourseDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update course details
    @PostMapping
    public CourseDetails saveCourseDetails(@RequestBody CourseDetails courseDetails) {
        return courseDetailsService.saveCourseDetails(courseDetails);
    }

    // Delete course details by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseDetails(@PathVariable Long id) {
        courseDetailsService.deleteCourseDetails(id);
        return ResponseEntity.noContent().build();
    }
}

