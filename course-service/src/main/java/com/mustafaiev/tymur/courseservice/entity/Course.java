package com.mustafaiev.tymur.courseservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DurationUnit durationUnit;

    public enum DurationUnit {
        DAYS, WEEKS, MONTHS, YEARS
    }
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

    // Конструкторы, геттеры и сеттеры
    public Course() {}

    public Course(String name, String description, Integer duration, Boolean diploma, Boolean intern) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.diploma = diploma;
        this.intern = intern;
    }

    public Long getId() {
        return id;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
        this.durationUnit = durationUnit;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
}
