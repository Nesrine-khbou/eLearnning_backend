package com.backend.application.services;

import com.backend.application.entities.Course;
import com.backend.application.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // New method to update a course
    public Course updateCourse(Long id, Course courseDetails) {
        // Check if course exists
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));

        // Update the existing course with new details
        existingCourse.setTitle(courseDetails.getTitle());
        existingCourse.setDescription(courseDetails.getDescription());
        existingCourse.setDuration(courseDetails.getDuration());
        existingCourse.setImageUrl(courseDetails.getImageUrl());
        existingCourse.setWhatWillLearn(courseDetails.getWhatWillLearn()); // No change needed

        // Save and return the updated course
        return courseRepository.save(existingCourse);
    }

}
