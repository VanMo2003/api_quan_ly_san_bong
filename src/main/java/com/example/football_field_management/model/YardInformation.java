package com.example.football_field_management.model;

import java.util.Objects;
public class YardInformation {
	String nameUser;
	String phoneNumber;
	int timeSlot;
	String dataToday;
	public YardInformation(){

	}

	public YardInformation(String nameUser, String phoneNumber, int timeSlot, String dataToday) {
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

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
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
		return "YardInformation{" +
				"nameUser='" + nameUser + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", timeSlot='" + timeSlot + '\'' +
				", dataToday='" + dataToday + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof YardInformation that)) return false;
		return Objects.equals(getNameUser(), that.getNameUser()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getTimeSlot(), that.getTimeSlot()) && Objects.equals(getDataToday(), that.getDataToday());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNameUser(), getPhoneNumber(), getTimeSlot(), getDataToday());
	}
}
