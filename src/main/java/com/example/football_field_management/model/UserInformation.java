package com.example.football_field_management.model;

public class UserInformation {
    private String nameUser;
    private String phoneNumber;
    private String timeSlot;
    private String dataToday;

    public UserInformation() {
    }

    public UserInformation(String nameUser, String phoneNumber, String timeSlot, String dataToday) {
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
        this.timeSlot = timeSlot;
        this.dataToday = dataToday;
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
        return "UserInformation{" +
                "nameUser='" + nameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", dataToday='" + dataToday + '\'' +
                '}';
    }
}
