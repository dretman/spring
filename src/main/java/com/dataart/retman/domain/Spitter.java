package com.dataart.retman.domain;

import javax.persistence.*;

@Entity
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

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "FULLNAME")
    public String getFullName() {
        return fullName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "ISUPDATEDBYID")
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
