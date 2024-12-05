package com.backend.application.controllers;

import com.backend.application.entities.Instructor;
import com.backend.application.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public Optional<Instructor> getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }
}
