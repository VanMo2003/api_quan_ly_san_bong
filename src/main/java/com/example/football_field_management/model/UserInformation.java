package com.example.football_field_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_information")
public class UserInformation {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "permission")
    private boolean permission;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "phone_number")
    private String phoneNumber;

    public UserInformation() {
    }

    public UserInformation(String username, boolean permission, String nameUser, String phoneNumber) {
        this.email = username;
        this.permission = permission;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
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
        if (!(o instanceof UserInformation)) return false;
        UserInformation userInformation = (UserInformation) o;
        return isPermission() == userInformation.isPermission() && Objects.equals(getEmail(), userInformation.getEmail()) && Objects.equals(getNameUser(), userInformation.getNameUser()) && Objects.equals(getPhoneNumber(), userInformation.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), isPermission(), getNameUser(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "username='" + email + '\'' +
                ", permission=" + permission +
                ", nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
