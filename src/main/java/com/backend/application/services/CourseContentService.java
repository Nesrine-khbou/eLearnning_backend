package com.backend.application.services;

import com.backend.application.entities.CourseContent;
import com.backend.application.repositories.CourseContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseContentService {

    @Autowired
    private CourseContentRepository courseContentRepository;

    // Retrieve all CourseContent
    public List<CourseContent> getAllCourseContents() {
        return courseContentRepository.findAll();
    }

    // Retrieve CourseContent by ID
    public Optional<CourseContent> getCourseContentById(Long id) {
        return courseContentRepository.findById(id);
    }

    // Save or Update CourseContent
    public CourseContent saveCourseContent(CourseContent courseContent) {
        return courseContentRepository.save(courseContent);
    }

    // Delete CourseContent by ID
    public void deleteCourseContent(Long id) {
        courseContentRepository.deleteById(id);
    }
}
