package com.backend.application.services;

import com.backend.application.DTO.CourseDTO;
import com.backend.application.entities.Course;
import com.backend.application.entities.CourseDetails;
import com.backend.application.entities.Instructor;
import com.backend.application.repositories.CourseDetailsRepository;
import com.backend.application.repositories.CourseRepository;
import com.backend.application.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseDetailsRepository courseDetailsRepository;

    public CourseService(CourseRepository courseRepository,
                         InstructorRepository instructorRepository,
                         CourseDetailsRepository courseDetailsRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.courseDetailsRepository = courseDetailsRepository;
    }

    /**
     * Save a new Course using CourseDTO.
     *
     * @param courseDTO the data transfer object containing course information
     * @return the saved Course entity
     */
    public Course saveCourse(CourseDTO courseDTO) {
        // Fetch the Instructor by ID
        Instructor instructor = instructorRepository.findById(courseDTO.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found with ID: " + courseDTO.getInstructorId()));

        // Fetch the CourseDetails by ID
        CourseDetails courseDetails = courseDetailsRepository.findById(courseDTO.getCourseDetailsId())
                .orElseThrow(() -> new RuntimeException("CourseDetails not found with ID: " + courseDTO.getCourseDetailsId()));

        // Map DTO to Entity
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setImage(courseDTO.getImage());
        course.setDetailsLink(courseDTO.getDetailsLink());
        course.setInstructor(instructor);
        course.setCourseDetails(courseDetails);

        // Save the Course
        return courseRepository.save(course);
    }

    /**
     * Update an existing Course by ID.
     *
     * @param id        the ID of the Course to update
     * @param courseDTO the data transfer object containing updated course information
     * @return the updated Course entity
     */
    public Course updateCourse(Long id, CourseDTO courseDTO) {
        // Fetch the existing Course by ID
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));

        // Fetch the Instructor by ID
        Instructor instructor = instructorRepository.findById(courseDTO.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found with ID: " + courseDTO.getInstructorId()));

        // Fetch the CourseDetails by ID
        CourseDetails courseDetails = courseDetailsRepository.findById(courseDTO.getCourseDetailsId())
                .orElseThrow(() -> new RuntimeException("CourseDetails not found with ID: " + courseDTO.getCourseDetailsId()));

        // Update the Course entity
        existingCourse.setTitle(courseDTO.getTitle());
        existingCourse.setImage(courseDTO.getImage());
        existingCourse.setDetailsLink(courseDTO.getDetailsLink());
        existingCourse.setInstructor(instructor);
        existingCourse.setCourseDetails(courseDetails);

        // Save the updated Course
        return courseRepository.save(existingCourse);
    }

    /**
     * Get a Course by ID.
     *
     * @param id the ID of the Course to retrieve
     * @return the Course entity
     */
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
    }

    /**
     * Get all Courses.
     *
     * @return a list of all Course entities
     */
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Delete a Course by ID.
     *
     * @param id the ID of the Course to delete
     */
    public void deleteCourse(Long id) {
        // Check if the Course exists
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with ID: " + id);
        }

        // Delete the Course
        courseRepository.deleteById(id);
    }
}
