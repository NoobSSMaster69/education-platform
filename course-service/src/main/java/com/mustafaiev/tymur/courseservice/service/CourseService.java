package com.mustafaiev.tymur.courseservice.service;

import com.mustafaiev.tymur.courseservice.DTO.CourseRequestDto;
import com.mustafaiev.tymur.courseservice.entity.Category;
import com.mustafaiev.tymur.courseservice.entity.Course;
import com.mustafaiev.tymur.courseservice.entity.User;
import com.mustafaiev.tymur.courseservice.repository.CategoryRepository;
import com.mustafaiev.tymur.courseservice.repository.CourseRepository;
import com.mustafaiev.tymur.courseservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
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

    @Transactional
    public Course createCourseWithCategoriesAndUsers(CourseRequestDto courseRequest) {
        // Создаем объект Course и заполняем его данными из запроса
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        course.setDiploma(courseRequest.getDiploma());
        course.setIntern(courseRequest.getIntern());
        course.setStartDate(courseRequest.getStartDate());
        course.setDifficulty(Course.Difficulty.valueOf(courseRequest.getDifficulty())); // Если это Enum
        course.setDurationUnit(Course.DurationUnit.valueOf(courseRequest.getDurationUnit())); // Если это Enum
        course.setPrice(courseRequest.getPrice());  // Устанавливаем цену курса из DTO


        // Обработка категорий
        Set<Category> categories = courseRequest.getCategories().stream()
                .map(categoryName -> categoryRepository.findByName(categoryName)
                        .orElseGet(() -> {
                            // Создаем категорию, если не существует
                            Category newCategory = new Category();
                            newCategory.setName(categoryName);
                            return categoryRepository.save(newCategory);
                        }))
                .collect(Collectors.toSet());
        course.setCategories(categories);

        // Обработка пользователей
        Set<User> users = courseRequest.getUserNames().stream()
                .map(userName -> userRepository.findByName(userName)
                        .orElseGet(() -> {
                            // Создаем пользователя, если не существует
                            User newUser = new User(userName);
                            // Здесь можно задать дополнительные поля, если они необходимы
                            return userRepository.save(newUser);
                        }))
                .collect(Collectors.toSet());
        course.setUsers(users);

        // Сохраняем курс в базе данных
        return courseRepository.save(course);
    }



//    @Transactional
//    public Course createCourseWithCategoriesAndUsers(CourseRequestDto courseRequest) {
//        // Создаем объект Course и заполняем его данными из запроса
//        Course course = new Course();
//        course.setName(courseRequest.getName());
//        course.setDescription(courseRequest.getDescription());
//        course.setDuration(courseRequest.getDuration());
//        course.setDiploma(courseRequest.getDiploma());
//        course.setIntern(courseRequest.getIntern());
//        course.setStartDate(courseRequest.getStartDate());
//
//        // Преобразуем категории в объекты
//        Set<Category> categories = courseRequest.getCategories().stream()
//                .map(categoryName -> categoryRepository.findByName(categoryName)
//                        .orElseThrow(() -> new RuntimeException("Category not found: " + categoryName)))
//                .collect(Collectors.toSet());
//        course.setCategories(categories);
//
//        // Находим пользователей по именам из CourseRequestDto
//        Set<User> users = userRepository.findByNameIn(new ArrayList<>(courseRequest.getUserNames()));
//        course.setUsers(users);
//
//        // Проверка на отсутствие пользователей
//        if (users.isEmpty()) {
//            throw new RuntimeException("No users found for the provided names.");
//        }
//        // Сохраняем курс в базе данных
//        return courseRepository.save(course);
//    }
}

