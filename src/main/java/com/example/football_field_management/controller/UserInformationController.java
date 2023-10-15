package com.example.football_field_management.controller;

import com.example.football_field_management.model.UserInformation;
import com.example.football_field_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/userInformation")
public class UserInformationController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/{username}")
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username){
        Optional<UserInformation> userFound = repository.findById(username);

        if (userFound.isPresent()){
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("không tìm thấy tài khoản", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> insertUser(@RequestBody UserInformation userInformation){
        return new ResponseEntity<>(repository.save(userInformation), HttpStatus.OK);
    }
}
