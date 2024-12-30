package com.mustafaiev.tymur.courseservice.repository;

import com.mustafaiev.tymur.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContainingIgnoreCase(String name);
}