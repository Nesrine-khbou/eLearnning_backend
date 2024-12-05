package com.backend.application.controllers;

import com.backend.application.entities.Content;
import com.backend.application.entities.Course;
import com.backend.application.services.ContentService;
import com.backend.application.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;
    private final CourseService courseService;

    // Constructor injection
    public ContentController(ContentService contentService, CourseService courseService) {
        this.contentService = contentService;
        this.courseService = courseService;
    }

    @PostMapping
    public Content addContentToCourse(@RequestBody Content contentRequest) {
        System.out.println("Received Course ID: " + contentRequest.getCourse().getId());

        // Retrieve the Course entity using the id provided in the request body
        Course course = courseService.getCourseById(contentRequest.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + contentRequest.getCourse().getId()));

        // Set the Course to the Content object
        contentRequest.setCourse(course);

        // Save and return the Content object
        return contentService.saveContent(contentRequest);
    }


    @GetMapping
    public List<Content> getAllContents() {
        return contentService.getAllContents();
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Long id) {
        return contentService.getContentById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable Long id, @RequestBody Content contentRequest) {
        return contentService.updateContent(id, contentRequest);
    }
}
