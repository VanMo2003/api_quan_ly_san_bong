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
    private int timeSlot;
    @Column(name = "selected_day")
    private String selectedDay;
    @Column(name = "price")
    private double price;

    public UserData() {
    }

    public UserData(Long id, String nameFootballField, int numberYard, String nameUser, String phoneNumber, int timeSlot, String selectedDay, double price) {
        this.id = id;
        this.nameFootballField = nameFootballField;
        this.numberYard = numberYard;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.selectedDay = selectedDay;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(String selectedDay) {
        this.selectedDay = selectedDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", nameFootballField='" + nameFootballField + '\'' +
                ", numberYard=" + numberYard +
                ", nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", timeSlot=" + timeSlot +
                ", dataToday='" + selectedDay + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;
        UserData userData = (UserData) o;
        return getNumberYard() == userData.getNumberYard() && getTimeSlot() == userData.getTimeSlot() && Objects.equals(getNameFootballField(), userData.getNameFootballField()) && Objects.equals(getSelectedDay(), userData.getSelectedDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameFootballField(), getNumberYard(), getTimeSlot(), getSelectedDay());
    }
}
