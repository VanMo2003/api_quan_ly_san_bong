package com.example.football_field_management.controller;

import com.example.football_field_management.model.UserData;
import com.example.football_field_management.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/userData")
public class UserDataController {

    @Autowired
    private UserDataRepository repositoryUserData;


    @PostMapping("")
    ResponseEntity<Object> getUserData(@RequestBody UserData userData){
        System.out.println(userData);
        List<UserData> userDataListFound = repositoryUserData.findByNameFootballField(userData.getNameFootballField());
        AtomicReference<UserData> userDataFound = new AtomicReference<>(new UserData());
        userDataListFound.forEach(userDataIndex -> {
            if (userDataIndex.equals(userData)){
                userDataFound.set(userDataIndex);
            }
        });
        return new ResponseEntity<>(userDataFound, HttpStatus.OK);
    }

    @GetMapping("/{nameFootballField}/{selectedTime}")
    ResponseEntity<Object> getUserDataByNameFootballFieldAndSelectedTime(
            @PathVariable String nameFootballField,
            @PathVariable String selectedTime){
        List<UserData> userDataListFound = repositoryUserData.findByNameFootballField(nameFootballField);

        List<UserData> result = userDataListFound.stream().filter(userData -> userData.getSelectedDay().equals(selectedTime)).collect(Collectors.toList());


        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<Object> insertUserData(@RequestBody UserData userData){

        return new ResponseEntity<>(repositoryUserData.save(userData), HttpStatus.OK);
    }
//    @DeleteMapping("")
//    public ResponseEntity<Object> deleteUser(@RequestBody UserData userData){
//        AtomicBoolean checkUserData = new AtomicBoolean(false);
//        repositoryUserData.findByNameFootballField(userData.getNameFootballField()).forEach(userData1 -> {
//            if (userData1.equals(userData)){
//                checkUserData.set(true);
//            }
//        });
//
//        if (checkUserData.get()){
//            repositoryUserData.delete(userData);
//            return new ResponseEntity<>(userData, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>("UserInformation Data not exists", HttpStatus.NOT_FOUND);
//        }
//    }
}
