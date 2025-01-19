package com.mustafaiev.tymur.courseservice.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

// DTO для запроса на создание курса
public class CourseRequestDto {
    private String name;
    private String description;
    private Integer duration;
    private String difficulty; // Новое поле для сложности
    private String durationUnit; // Новое поле для единицы измерения времени
    private Boolean diploma;
    private Boolean intern;
    private LocalDate startDate;
    private Set<String> userNames;
    private Set<String> categories;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    // Геттеры и сеттеры
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

    public Set<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(Set<String> userNames) {
        this.userNames = userNames;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
