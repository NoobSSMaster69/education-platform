package com.mustafaiev.tymur.courseservice.service;

import com.mustafaiev.tymur.courseservice.entity.Course;
import com.mustafaiev.tymur.courseservice.repository.CategoryRepository;
import com.mustafaiev.tymur.courseservice.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseService(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setDescription(updatedCourse.getDescription());
                    course.setDuration(updatedCourse.getDuration());
                    course.setDurationUnit(updatedCourse.getDurationUnit());
                    course.setDiploma(updatedCourse.getDiploma());
                    course.setIntern(updatedCourse.getIntern());
                    course.setStartDate(updatedCourse.getStartDate());
                    course.setCategories(updatedCourse.getCategories());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

