package com.dataart.retman.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    private long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 25)
    private String lastName;

    @NotNull
    @Size(min = 4, max = 30)
    private String username;

    @NotNull
    @Size(min = 5, max = 16)
    private String password;

    public Spitter() {
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Spitter)) {
            return false;
        }

        Spitter user = (Spitter) o;

        return user.username.equals(username) &&
                user.firstName.equals(firstName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "|"
                + firstName + "|"
                + lastName + "|"
                + username + "|"
                + password;
    }
}
