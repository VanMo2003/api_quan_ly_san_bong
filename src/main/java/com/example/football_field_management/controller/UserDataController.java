package com.example.football_field_management.controller;

import com.example.football_field_management.model.ManageInformation;
import com.example.football_field_management.model.UserData;
import com.example.football_field_management.repositories.ManageInformationRepository;
import com.example.football_field_management.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@CrossOrigin
@RestController
@RequestMapping(path = "/userdata")
public class UserDataController {

    @Autowired
    private UserDataRepository repositoryUserData;
    @Autowired
    private ManageInformationRepository manageInformationRepository;


    @GetMapping("")
    ResponseEntity<Object> getAllUserData(){
        return new ResponseEntity<>(repositoryUserData.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> insertUserData(@RequestBody UserData userData){
        Optional<ManageInformation> manageInformationFound = manageInformationRepository.findById(userData.getNameFootballField());

        if (manageInformationFound.isPresent()) {
            if (manageInformationFound.get().getTotalYards() >= userData.getNumberYard()) {
                List<UserData> userDataList = repositoryUserData.findByNameFootballField(userData.getNameFootballField());
               AtomicBoolean checkUserData = new AtomicBoolean(false);
                userDataList.forEach(userData1 -> {
                    if (userData1.equals(userData)){
                        checkUserData.set(true);
                    }
                });

                if (!checkUserData.get()){
                    return new ResponseEntity<>(repositoryUserData.save(userData), HttpStatus.OK);
                }else {
                    return new ResponseEntity<>("This yard is already occupied", HttpStatus.BAD_REQUEST);
                }

            }else {
                return new ResponseEntity<>("The Football Field has only " + manageInformationFound.get().getTotalYards() + " yard", HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<>("Name Football Field not exists", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("")
    public ResponseEntity<Object> deleteUser(@RequestBody UserData userData){
        AtomicBoolean checkUserData = new AtomicBoolean(false);
        repositoryUserData.findByNameFootballField(userData.getNameFootballField()).forEach(userData1 -> {
            if (userData1.equals(userData)){
                checkUserData.set(true);
            }
        });

        if (checkUserData.get()){
            repositoryUserData.delete(userData);
            return new ResponseEntity<>(userData, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User Data not exists", HttpStatus.NOT_FOUND);
        }
    }
}
