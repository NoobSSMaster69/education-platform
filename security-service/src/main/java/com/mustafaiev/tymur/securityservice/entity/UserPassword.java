package com.mustafaiev.tymur.securityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserPassword {

    @Id
    private Long userId;        // User ID (Primary key)

    @NotBlank(message = "Password hash must not be empty")
    private String passwordHash; // Password hash (e.g., using bcrypt)

    // Default constructor
    public UserPassword() {}

    // Constructor with parameters
    public UserPassword(Long userId, String passwordHash) {
        this.userId = userId;
        this.passwordHash = passwordHash;
    }

    // Getter for userId
    public Long getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter for passwordHash
    public String getPasswordHash() {
        return passwordHash;
    }

    // Setter for passwordHash
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
