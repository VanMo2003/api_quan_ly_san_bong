package com.example.football_field_management.model;

import java.util.Objects;
public class YardInformation {
	String nameUser;
	String phoneNumber;
	int timeSlot;
	String selectedDay;
	public YardInformation(){

	}

	public YardInformation(String nameUser, String phoneNumber, int timeSlot, String selectedDay) {
		this.nameUser = nameUser;
		this.phoneNumber = phoneNumber;
		this.timeSlot = timeSlot;
		this.selectedDay = selectedDay;
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

	@Override
	public String toString() {
		return "YardInformation{" +
				"nameUser='" + nameUser + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", timeSlot='" + timeSlot + '\'' +
				", dataToday='" + selectedDay + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof YardInformation that)) return false;
		return getTimeSlot() == that.getTimeSlot() && Objects.equals(getNameUser(), that.getNameUser()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getSelectedDay(), that.getSelectedDay());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNameUser(), getPhoneNumber(), getTimeSlot(), getSelectedDay());
	}
}
