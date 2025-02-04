package com.backend.application.controllers;

import com.backend.application.entities.Course;
import com.backend.application.entities.Instructor;
import com.backend.application.services.CourseService;
import com.backend.application.services.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final InstructorService instructorService;

    public CourseController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        if (course.getInstructorId() != null) {
            // Fetch the instructor using the instructorId
            Instructor instructor = instructorService.getInstructorById(course.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + course.getInstructorId()));
            // Set the instructor to the course
            course.setInstructor(instructor);
        }
        // Save and return the course
        return courseService.saveCourse(course);
    }


    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }
}
