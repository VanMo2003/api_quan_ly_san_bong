package com.example.football_field_management.controller;

import com.example.football_field_management.model.User;
import com.example.football_field_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/{username}")
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username){
        Optional<User> user = repository.findById(username);

        if (user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Username not exists", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> insertUser(@RequestBody User user){
        return new ResponseEntity<>(repository.save(user), HttpStatus.OK);
    }
}
