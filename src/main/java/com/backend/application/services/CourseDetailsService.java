package com.backend.application.services;

import com.backend.application.entities.CourseDetails;
import com.backend.application.repositories.CourseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsService {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    // Retrieve all CourseDetails
    public List<CourseDetails> getAllCourseDetails() {
        return courseDetailsRepository.findAll();
    }

    // Retrieve CourseDetails by ID
    public Optional<CourseDetails> getCourseDetailsById(Long id) {
        return courseDetailsRepository.findById(id);
    }

    // Save or Update CourseDetails
    public CourseDetails saveCourseDetails(CourseDetails courseDetails) {
        return courseDetailsRepository.save(courseDetails);
    }

    // Delete CourseDetails by ID
    public void deleteCourseDetails(Long id) {
        courseDetailsRepository.deleteById(id);
    }
}
