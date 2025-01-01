package com.mustafaiev.tymur.courseservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.lang.math.RandomUtils;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private Long id; // Идентификатор задаётся вручную

    @NotBlank
    @Column(nullable = false)
    private String name; // Имя школы

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses = new HashSet<>();

    // Конструкторы, геттеры, сеттеры
    public User() {}

    public User(String name) {
        this.id = RandomUtils.nextLong();
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
