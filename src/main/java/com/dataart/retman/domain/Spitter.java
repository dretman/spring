package com.dataart.retman.domain;

public class Spitter {
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean isUpdatedById;

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

    public void setUpdatedById(boolean updatedById) {
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
