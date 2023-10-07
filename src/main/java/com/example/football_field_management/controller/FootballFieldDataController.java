package com.example.football_field_management.controller;

import com.example.football_field_management.model.UserData;
import com.example.football_field_management.model.UserInformation;
import com.example.football_field_management.model.YardData;
import com.example.football_field_management.repositories.ManageInformationRepository;
import com.example.football_field_management.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class FootballFieldDataController {
    @Autowired
    private UserDataRepository repository;
    @Autowired
    private ManageInformationRepository manageInformationRepository;

    @GetMapping("/{nameFootballField}")
    public ResponseEntity<Object> getAllFootballFieldData(@PathVariable String nameFootballField){
        List<UserData> userDataList = repository.findByNameFootballField(nameFootballField.trim());

        if (userDataList.isEmpty()){
            return new ResponseEntity<>("không tìm thấy tên sân bóng", HttpStatus.NOT_FOUND);
        }else {
            List<YardData> yardDataList = new ArrayList<>();

            for (int i = 1; i <= manageInformationRepository.findById(nameFootballField).get().getTotalYards(); i++) {
                YardData yardData = new YardData();
                List<UserInformation> userInformationList = new ArrayList<>();


                int finalI = i;
                userDataList.forEach(userData -> {
                    if (userData.getNumberYard() == finalI) {
                        userInformationList.add(new UserInformation(userData.getNameUser(), userData.getPhoneNumber(), userData.getTimeSlot(), userData.getDataToday()));
                    }
                });

                yardData.setNumberYard(i);
                yardData.setUserInformationList(userInformationList);

                yardDataList.add(yardData);
            }

            return new ResponseEntity<>(yardDataList, HttpStatus.OK);
        }
    }

    @GetMapping("/{nameFootballField}/{numberYard}")
    public ResponseEntity<Object> getAllFootballFieldData(@PathVariable String nameFootballField, @PathVariable int numberYard){
        List<UserData> userDataList = repository.findByNameFootballField(nameFootballField.trim());

        if (userDataList.isEmpty()){
            return new ResponseEntity<>("không tìm thấy tên sân bóng", HttpStatus.NOT_FOUND);
        }else {
            int totalYards = manageInformationRepository.findById(nameFootballField).get().getTotalYards();
            if (totalYards < numberYard){
                return new ResponseEntity<>("Sân bóng chỉ có " +totalYards +" sân", HttpStatus.BAD_REQUEST);
            }
            List<UserInformation> userInformationList = new ArrayList<>();

            userDataList.forEach(userData -> {
                if (userData.getNumberYard() == numberYard){
                    UserInformation userInformation = new UserInformation();
                    userInformation.setNameUser(userData.getNameUser());
                    userInformation.setPhoneNumber(userData.getPhoneNumber());
                    userInformation.setTimeSlot(userData.getTimeSlot());
                    userInformation.setDataToday(userData.getDataToday());

                    userInformationList.add(userInformation);
                }
            });
            if (userInformationList.isEmpty()){
                return new ResponseEntity<>("Rỗng",HttpStatus.OK);
            }
            return new ResponseEntity<>(userInformationList, HttpStatus.OK);
        }

    }
}
