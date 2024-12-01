package com.backend.application.controllers;

import com.backend.application.DTO.CourseDTO;
import com.backend.application.entities.Course;
import com.backend.application.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Create a new course.
     *
     * @param courseDTO the data transfer object containing course details
     * @return ResponseEntity containing the saved course
     */
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        Course savedCourse = courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    /**
     * Update an existing course by ID.
     *
     * @param id        the ID of the course to update
     * @param courseDTO the data transfer object containing updated course details
     * @return ResponseEntity containing the updated course
     */
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        Course updatedCourse = courseService.updateCourse(id, courseDTO);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    /**
     * Retrieve a course by ID.
     *
     * @param id the ID of the course to retrieve
     * @return ResponseEntity containing the requested course
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    /**
     * Retrieve all courses.
     *
     * @return ResponseEntity containing a list of all courses
     */
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    /**
     * Delete a course by ID.
     *
     * @param id the ID of the course to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
