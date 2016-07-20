package com.dataart.retman.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    private long id;

    @NotNull
    @NotBlank(message = "{firstName.blank}")
    @Size(min = 5, max = 16, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 25, message = "{lastName.size}")
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 30, message = "{username.size}")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 16, message = "{password.size}")
    private String password;

    public Spitter() {
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.username = username.trim();
        this.password = password.trim();
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

    public static void main(String[] args) {
        String strClassPath = System.getProperty("java.class.path");

        System.out.println("Classpath is " + strClassPath);

    }
}
