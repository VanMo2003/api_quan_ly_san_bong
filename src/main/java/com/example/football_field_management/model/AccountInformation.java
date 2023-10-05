package com.example.football_field_management.model;

public class AccountInformation {
    private String username;
    private boolean permission;
    private String nameFootballField;
    private String nameManage;
    private int totalYards;

    public AccountInformation() {
    }

    public AccountInformation(String username, boolean permission, String nameFootballField, String nameManage, int totalYards) {
        this.username = username;
        this.permission = permission;
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
        return "AccountInformation{" +
                "username='" + username + '\'' +
                ", permission=" + permission +
                ", nameFootballField='" + nameFootballField + '\'' +
                ", nameManage='" + nameManage + '\'' +
                ", totalYards=" + totalYards +
                '}';
    }
}
