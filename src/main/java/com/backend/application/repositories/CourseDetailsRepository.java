package com.backend.application.repositories;

import com.backend.application.entities.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {
}
