package com.backend.application.services;

import com.backend.application.entities.Instructor;
import com.backend.application.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor instructor = existingInstructor.get();
            instructor.setUsername(updatedInstructor.getUsername());
            instructor.setEmail(updatedInstructor.getEmail());
            instructor.setPassword(updatedInstructor.getPassword());
            instructor.setTotalStudents(updatedInstructor.getTotalStudents());
            instructor.setInstructorRating(updatedInstructor.getInstructorRating());
            instructor.setTotalReviews(updatedInstructor.getTotalReviews());
            return instructorRepository.save(instructor);
        }
        throw new RuntimeException("Instructor not found with id: " + id);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}
