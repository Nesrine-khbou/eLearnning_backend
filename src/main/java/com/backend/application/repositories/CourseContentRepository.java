package com.backend.application.repositories;


import com.backend.application.entities.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseContentRepository extends JpaRepository<CourseContent, Long> {
}
