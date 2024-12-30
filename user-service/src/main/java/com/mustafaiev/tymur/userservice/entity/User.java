package com.mustafaiev.tymur.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;           // User identifier

    @NotBlank(message = "First name cannot be empty or consist only of whitespace")
    private String firstName;  // User's first name

    @NotBlank(message = "Last name cannot be empty or consist only of whitespace")
    private String lastName;   // User's last name

    @NotBlank(message = "Email cannot be empty or consist only of whitespace")
    private String email;      // User's email address

    private String phoneNumber; // User's phone number

    private String profilePictureUrl; // URL to user's profile picture

    // Default constructor required for JPA
    public User() {
    }

    // Constructor to create a user with provided fields
    public User(String firstName, String lastName, String email, String phoneNumber, String profilePictureUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePictureUrl = profilePictureUrl;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

}
