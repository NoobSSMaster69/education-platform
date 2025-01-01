package com.mustafaiev.tymur.courseservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DurationUnit durationUnit;

    @NotNull
    @Column(nullable = false)
    private Boolean diploma;

    @NotNull
    @Column(nullable = false)
    private Boolean intern;

    private LocalDate startDate;

    @ManyToMany
    @JoinTable(
            name = "course_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "course_user",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    // Конструктор с параметрами для всех полей
    public Course(String name, String description, Integer duration, BigDecimal price, Difficulty difficulty,
                  DurationUnit durationUnit, Boolean diploma, Boolean intern, LocalDate startDate,
                  Set<Category> categories, Set<User> users) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.difficulty = difficulty;
        this.durationUnit = durationUnit;
        this.diploma = diploma;
        this.intern = intern;
        this.startDate = startDate;
        this.categories = categories != null ? categories : new HashSet<>();
        this.users = users != null ? users : new HashSet<>();
    }

    // Конструктор по умолчанию
    public Course() {}

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
        this.durationUnit = durationUnit;
    }

    public Boolean getDiploma() {
        return diploma;
    }

    public void setDiploma(Boolean diploma) {
        this.diploma = diploma;
    }

    public Boolean getIntern() {
        return intern;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // Перечисления для сложности и единиц времени
    public enum Difficulty {
        LOW, MEDIUM, HIGH
    }

    public enum DurationUnit {
        DAYS, WEEKS, MONTHS, YEARS
    }
}
