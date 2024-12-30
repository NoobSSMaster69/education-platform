package com.mustafaiev.tymur.securityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // Identifier for the record

    @NotNull
    private Long userId;      // User ID (referencing the user from another service)

    @ManyToOne
    private Role role;        // Role of the user

    // Default constructor
    public UserRole() {}

    // Constructor with parameters
    public UserRole(Long userId, Role role) {
        this.userId = userId;
        this.role = role;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for userId
    public Long getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter for role
    public Role getRole() {
        return role;
    }

    // Setter for role
    public void setRole(Role role) {
        this.role = role;
    }
}
