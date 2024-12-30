package com.mustafaiev.tymur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class CourseReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long userId; // Ссылка на пользователя (может быть FK, если есть сущность User)

    @NotNull
    @Column(nullable = false)
    private Long courseId; // Ссылка на курс (может быть FK, если есть сущность Course)

    @NotNull
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private Integer rating; // Рейтинг от 1 до 5

    @NotBlank
    @Column(nullable = false, length = 500)
    private String description; // Описание отзыва с ограничением длины

    // Конструкторы, геттеры и сеттеры
    public CourseReview() {}

    public CourseReview(Long userId, Long courseId, Integer rating, String description) {
        this.userId = userId;
        this.courseId = courseId;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
