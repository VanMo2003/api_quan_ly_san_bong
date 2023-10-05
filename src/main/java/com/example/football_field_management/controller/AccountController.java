package com.example.football_field_management.controller;

import com.example.football_field_management.model.Account;
import com.example.football_field_management.repositories.AccountRepository;
import com.example.football_field_management.repositories.FootballFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private FootballFieldRepository repositoryFootballField;

    @GetMapping("")
    public ResponseEntity<Object> getAllAccount(){
      return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> getAccountByUsername(@RequestBody Account account){
        Optional<Account> accountFound = repository.findById(account.getUserName());

        if (!accountFound.isPresent()){
            return new ResponseEntity<>("Username not exists", HttpStatus.NOT_FOUND);
        } else {
            if (accountFound.get().equals(account)){
                return new ResponseEntity<>(accountFound.get().isPermission() ,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
            }
        }
    }
    @PostMapping("")
    public ResponseEntity<Object> insertAccount(@RequestBody Account account){
        Optional<Account> accountFound = repository.findById(account.getUserName());

        if (accountFound.isPresent()){
            return new ResponseEntity<>("Username existed", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.save(account), HttpStatus.OK);
        }
    }
}
