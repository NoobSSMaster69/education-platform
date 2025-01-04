package com.mustafaiev.tymur.courseservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "user_app")
public class User {
    @Id
    private Long id; // Идентификатор задаётся вручную

    @NotBlank
    @Column(nullable = false)
    private String name; // Имя школы

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();

    // Конструкторы, геттеры, сеттеры
    public User() {}

    public User(String name) {
        Random random = new Random();
        this.id = 1 + random.nextLong(100000 - 1);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
