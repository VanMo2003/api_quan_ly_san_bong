package com.example.football_field_management.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "football_field")
public class FootballFieldData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "name_football_field")
	String nameFootballField;
	@Column(name = "time_slot")
	int timeSlot;
	@Column(name = "price")
	String price;

	public FootballFieldData(String nameFootballField, int timeSlot, String price) {
		this.nameFootballField = nameFootballField;
		this.timeSlot = timeSlot;
		this.price = price;
	}

	public String getNameFootballField() {
		return nameFootballField;
	}

	public void setNameFootballField(String nameFootballField) {
		this.nameFootballField = nameFootballField;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FootballFieldData{" +
				"nameFootballField='" + nameFootballField + '\'' +
				", timeSlot='" + timeSlot + '\'' +
				", price='" + price + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FootballFieldData that)) return false;
		return Objects.equals(getNameFootballField(), that.getNameFootballField()) && Objects.equals(getTimeSlot(), that.getTimeSlot()) && Objects.equals(getPrice(), that.getPrice());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNameFootballField(), getTimeSlot(), getPrice());
	}
}
