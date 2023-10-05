package com.example.football_field_management.model;

import java.util.List;

public class YardData {
    private int numberYard;
    private List<UserInformation> userInformationList;

    public YardData() {
    }

    public YardData(int numberYard) {
        this.numberYard = numberYard;
    }

    public YardData(int numberYard, List<UserInformation> userInformationList) {
        this.numberYard = numberYard;
        this.userInformationList = userInformationList;
    }

    public int getNumberYard() {
        return numberYard;
    }

    public void setNumberYard(int numberYard) {
        this.numberYard = numberYard;
    }

    public List<UserInformation> getUserInformationList() {
        return userInformationList;
    }

    public void setUserInformationList(List<UserInformation> userInformationList) {
        this.userInformationList = userInformationList;
    }

    @Override
    public String toString() {
        return "YardData{" +
                "numberYard=" + numberYard +
                ", userInformationList=" + userInformationList +
                '}';
    }

}
