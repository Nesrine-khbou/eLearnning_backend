package com.backend.application.controllers;

import com.backend.application.entities.Enrollment;
import com.backend.application.entities.Student;
import com.backend.application.entities.Course;
import com.backend.application.services.EnrollmentService;
import com.backend.application.services.StudentService;
import com.backend.application.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }

    @PostMapping
    public Enrollment enrollStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Course course = courseService.getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        return enrollmentService.enrollStudentInCourse(student, course);
    }
    @DeleteMapping("/{id}")
    public void unenrollStudent(@PathVariable Long id) {
        enrollmentService.unenrollStudent(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }
}
