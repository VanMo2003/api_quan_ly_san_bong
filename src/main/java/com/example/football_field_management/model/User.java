package com.example.football_field_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(String username, String nameUser, String phoneNumber) {
        this.username = username;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
