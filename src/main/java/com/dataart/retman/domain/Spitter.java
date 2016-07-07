package com.dataart.retman.domain;

public class Spitter {
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean isUpdatedById;

    public Spitter() {
    }

    public Spitter(long id, String username, String password, String fullName, String email, boolean isUpdatedById) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.isUpdatedById = isUpdatedById;
    }



    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsUpdatedById() {
        return isUpdatedById;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsUpdatedById(boolean updatedById) {
        isUpdatedById = updatedById;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", isUpdatedById=" + isUpdatedById +
                '}';
    }
}
