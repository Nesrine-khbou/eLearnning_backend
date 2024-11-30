package com.backend.application.dao;

import com.backend.application.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> findCoursesByInstructor(Long instructorId) {
        String jpql = "SELECT c FROM Course c WHERE c.instructor.id = :instructorId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("instructorId", instructorId);
        return query.getResultList();
    }
}
