package com.mustafaiev.tymur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "reviewer_id", nullable = false)
    private Long reviewerId; // Идентификатор пользователя, который оставил отзыв

    @NotNull
    @Column(name = "reviewed_user_id", nullable = false)
    private Long reviewedUserId; // Идентификатор пользователя, который получил отзыв

    @NotNull
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private Integer rating; // Оценка (1-5)

    @Column(length = 500)
    private String description; // Описание отзыва

    // Конструкторы
    public UserReview() {}

    public UserReview(Long reviewerId, Long reviewedUserId, Integer rating, String description) {
        this.reviewerId = reviewerId;
        this.reviewedUserId = reviewedUserId;
        this.rating = rating;
        this.description = description;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getReviewedUserId() {
        return reviewedUserId;
    }

    public void setReviewedUserId(Long reviewedUserId) {
        this.reviewedUserId = reviewedUserId;
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
