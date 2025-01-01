package com.mustafaiev.tymur.courseservice.controller;

import com.mustafaiev.tymur.courseservice.DTO.CourseRequestDto;
import com.mustafaiev.tymur.courseservice.entity.Category;
import com.mustafaiev.tymur.courseservice.entity.Course;
import com.mustafaiev.tymur.courseservice.entity.User;
import com.mustafaiev.tymur.courseservice.service.CourseService;
import com.mustafaiev.tymur.courseservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;


    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @Operation(summary = "Get all courses", description = "Retrieve a list of all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of courses"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Operation(summary = "Get course by ID", description = "Retrieve a course by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the course"),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new course", description = "Create a new course with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the course"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    // Эндпоинт для создания курса с категориями и пользователями
    @PostMapping
    public ResponseEntity<Course> createCourseWithCategoriesAndUsers(
            @RequestBody CourseRequestDto courseRequest) {
        // Вызываем сервис для создания курса с категориями и пользователями
        Course createdCourse = courseService.createCourseWithCategoriesAndUsers(courseRequest);

        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing course", description = "Update the details of an existing course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the course"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody @Valid Course course) {
        try {
            return ResponseEntity.ok(courseService.updateCourse(id, course));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a course", description = "Delete an existing course by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the course"),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
