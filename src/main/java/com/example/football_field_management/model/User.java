package com.example.football_field_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "permission")
    private boolean permission;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(String username, boolean permission, String nameUser, String phoneNumber) {
        this.username = username;
        this.permission = permission;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isPermission() == user.isPermission() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getNameUser(), user.getNameUser()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), isPermission(), getNameUser(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", permission=" + permission +
                ", nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
