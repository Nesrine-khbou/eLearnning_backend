package com.backend.application.controllers;

import com.backend.application.entities.CourseContent;
import com.backend.application.services.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-content")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    // Get all course content
    @GetMapping
    public List<CourseContent> getAllCourseContents() {
        return courseContentService.getAllCourseContents();
    }

    // Get course content by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseContent> getCourseContentById(@PathVariable Long id) {
        return courseContentService.getCourseContentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update course content
    @PostMapping
    public CourseContent saveCourseContent(@RequestBody CourseContent courseContent) {
        return courseContentService.saveCourseContent(courseContent);
    }

    // Delete course content by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseContent(@PathVariable Long id) {
        courseContentService.deleteCourseContent(id);
        return ResponseEntity.noContent().build();
    }
}
