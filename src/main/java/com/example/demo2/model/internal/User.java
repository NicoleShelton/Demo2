package com.example.demo2.model.internal;

public class User {
    private String firstName;
    private String lastName;
    private Long id;
    private Long locationId;
    private String jobTitle;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public User setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public User setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }
}
