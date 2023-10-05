package com.example.football_field_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "football_field")
public class FootballField {
    private String username;
    @Id
    @Column(name = "name_football_field")
    private String nameFootballField;
    @Column(name = "name_manage")
    private String nameManage;
    @Column(name = "total yard")
    private int totalYards;

    public FootballField() {
    }

    public FootballField(String username,String nameFootballField, String nameManage, int totalYards) {
        this.username = username;
        this.nameFootballField = nameFootballField;
        this.nameManage = nameManage;
        this.totalYards = totalYards;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameFootballField() {
        return nameFootballField;
    }
    public void setNameFootballField(String nameFootballField) {
        this.nameFootballField = nameFootballField;
    }

    public String getNameManage() {
        return nameManage;
    }

    public void setNameManage(String nameManage) {
        this.nameManage = nameManage;
    }

    public int getTotalYards() {
        return totalYards;
    }

    public void setTotalYards(int totalYards) {
        this.totalYards = totalYards;
    }


    @Override
    public String toString() {
        return "FootballField{" +
                "username='" + username + '\'' +
                ", nameFootballField='" + nameFootballField + '\'' +
                ", nameManage='" + nameManage + '\'' +
                ", totalYards=" + totalYards +
                '}';
    }
}
