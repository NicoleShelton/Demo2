package com.example.demo2.model.external.response;

public class GetUserResponse {
    public static class User {
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

        private String firstName;
        private String lastName;
        private Long id;
        private Long locationId;
        private String jobTitle;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public GetUserResponse setUser(User user) {
        this.user = user;
        return this;
    }
}
