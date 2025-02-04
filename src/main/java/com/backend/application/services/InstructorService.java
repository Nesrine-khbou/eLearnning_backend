package com.backend.application.services;

import com.backend.application.DTO.InstructorResponse;
import com.backend.application.entities.Course;
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

    public InstructorResponse updateInstructor(Long id, Instructor updatedInstructor) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor instructor = existingInstructor.get();
            instructor.setUsername(updatedInstructor.getUsername());
            instructor.setEmail(updatedInstructor.getEmail());
            instructor.setImage(updatedInstructor.getImage());
            instructor.setHeadline(updatedInstructor.getHeadline());
            instructor.setDescription(updatedInstructor.getDescription());
            instructorRepository.save(instructor);

            return new InstructorResponse(
                    updatedInstructor.getId(),
                    updatedInstructor.getUsername(),
                    updatedInstructor.getEmail(),
                    updatedInstructor.getImage(),
                    updatedInstructor.getHeadline(),
                    updatedInstructor.getDescription()
            );
        }
        throw new RuntimeException("Instructor not found with id: " + id);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    // Method to calculate the total reviews for an instructor
    public int getInstructorReviews(Long instructorId) {
        Optional<Instructor> instructorOpt = instructorRepository.findById(instructorId);
        if (instructorOpt.isPresent()) {
            Instructor instructor = instructorOpt.get();
            // Calculate the total number of reviews for all the instructor's courses
            return instructor.getCourses().stream()
                    .mapToInt(course -> course.getReviews().size()) // Assuming each course has a list of reviews
                    .sum();
        }
        throw new RuntimeException("Instructor not found with id: " + instructorId);
    }

    // Method to get the count of courses for an instructor
    public int getInstructorCoursesCount(Long instructorId) {
        Optional<Instructor> instructorOpt = instructorRepository.findById(instructorId);
        if (instructorOpt.isPresent()) {
            Instructor instructor = instructorOpt.get();
            return instructor.getCourses().size(); // Assuming instructor has a list of courses
        }
        throw new RuntimeException("Instructor not found with id: " + instructorId);
    }

        public List<Course> getInstructorCourses(Long instructorId) {
            return instructorRepository.findById(instructorId)
                    .map(Instructor::getCourses)
                    .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));
        }
    }

