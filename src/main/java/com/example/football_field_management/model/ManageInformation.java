package com.example.football_field_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "manage_information")
public class ManageInformation {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "permission")
    private boolean permission;
    @Column(name = "name_football_field")
    private String nameFootballField;
    @Column(name = "name_manage")
    private String nameManage;
    @Column(name = "total_yards")
    private int totalYards;

    public ManageInformation() {
    }

    public ManageInformation(String username, boolean permission, String nameFootballField, String nameManage, int totalYards) {
        this.email = username;
        this.permission = permission;
        this.nameFootballField = nameFootballField;
        this.nameManage = nameManage;
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
        return "ManageInformation{" +
                "username='" + email + '\'' +
                ", permission=" + permission +
                ", nameFootballField='" + nameFootballField + '\'' +
                ", nameManage='" + nameManage + '\'' +
                ", totalYards=" + totalYards +
                '}';
    }
}
