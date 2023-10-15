package com.example.football_field_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "football_field_information")
public class FootballFieldInformation {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "permission")
    private boolean permission;
    @Column(name = "name_football_field")
    private String nameFootballField;
    @Column(name = "name_manager")
    private String nameManager;
    @Column(name = "total_yards")
    private int totalYards;

    public FootballFieldInformation() {
    }

    public FootballFieldInformation(String username, boolean permission, String nameFootballField, String nameManager, int totalYards) {
        this.email = username;
        this.permission = permission;
        this.nameFootballField = nameFootballField;
        this.nameManager = nameManager;
        this.totalYards = totalYards;
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

    public String getNameFootballField() {
        return nameFootballField;
    }

    public void setNameFootballField(String nameFootballField) {
        this.nameFootballField = nameFootballField;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public int getTotalYards() {
        return totalYards;
    }

    public void setTotalYards(int totalYards) {
        this.totalYards = totalYards;
    }

    @Override
    public String toString() {
        return "FootballFieldInformation{" +
                "username='" + email + '\'' +
                ", permission=" + permission +
                ", nameFootballField='" + nameFootballField + '\'' +
                ", nameManage='" + nameManager + '\'' +
                ", totalYards=" + totalYards +
                '}';
    }
}
