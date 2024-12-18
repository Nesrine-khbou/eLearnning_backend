package com.backend.application.services;

import com.backend.application.DTO.StudentResponse;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public StudentResponse updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            // Update existing fields
            student.setUsername(updatedStudent.getUsername());
            student.setEmail(updatedStudent.getEmail());
            // Update new image field
            student.setImage(updatedStudent.getImage());

            studentRepository.save(student);
            return new StudentResponse(updatedStudent.getId(),updatedStudent.getUsername(), updatedStudent.getEmail(), updatedStudent.getImage());
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
