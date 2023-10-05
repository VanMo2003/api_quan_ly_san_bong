package com.example.football_field_management.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_football_field")
    private String nameFootballField;
    @Column(name = "number_yard")
    private int numberYard;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "time_slot")
    private String timeSlot;
    @Column(name = "data_today")
    private String dataToday;

    public UserData() {
    }

    public UserData(String nameFootballField, int numberYard, String nameUser, String phoneNumber, String timeSlot, String dataToday) {
        this.nameFootballField = nameFootballField;
        this.numberYard = numberYard;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.dataToday = dataToday;
    }

    public String getNameFootballField() {
        return nameFootballField;
    }

    public void setNameFootballField(String nameFootballField) {
        this.nameFootballField = nameFootballField;
    }

    public int getNumberYard() {
        return numberYard;
    }

    public void setNumberYard(int numberYard) {
        this.numberYard = numberYard;
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

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDataToday() {
        return dataToday;
    }

    public void setDataToday(String dataToday) {
        this.dataToday = dataToday;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "nameFootballField='" + nameFootballField + '\'' +
                ", numberYard=" + numberYard +
                ", nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", dataToday='" + dataToday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;
        UserData userData = (UserData) o;
        return getNumberYard() == userData.getNumberYard() && getNameFootballField().equals(userData.getNameFootballField()) && getTimeSlot().equals(userData.getTimeSlot()) && getDataToday().equals(userData.getDataToday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameFootballField(), getNumberYard(), getTimeSlot(), getDataToday());
    }
}
