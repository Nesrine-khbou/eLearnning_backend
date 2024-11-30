package com.backend.application.services;

import com.backend.application.entities.Student;
import com.backend.application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Retrieve all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Retrieve Student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Save or Update Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Delete Student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Enroll Student in a Course
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.getEnrolledCourses().add(courseId); // Add course to enrolledCourses
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found");
    }
}
