package com.example.football_field_management.controller;

import com.example.football_field_management.model.Account;
import com.example.football_field_management.repositories.AccountRepository;
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


    @GetMapping({"/", "/home", "/status"})
    public String getStatus() {
        return "Application is up and running";
    }
    @PostMapping("/login")
    public ResponseEntity<Object> getAccountByUsername(@RequestBody Account account){
        Optional<Account> accountFound = repository.findById(account.getEmail());

        if (!accountFound.isPresent()){
            return new ResponseEntity<>("tài khoản hoặc mật khẩu không chính xác", HttpStatus.NOT_FOUND);
        } else {
            if (account.getPassword().equals(accountFound.get().getPassword()))
                return new ResponseEntity<>(accountFound.get().isPermission(), HttpStatus.OK);
            else {
                return new ResponseEntity<>("tài khoản hoặc mật khẩu không chính xác", HttpStatus.BAD_REQUEST);
            }
        }
    }
    @PostMapping("")
    public ResponseEntity<Object> insertAccount(@RequestBody Account account){
        Optional<Account> accountFound = repository.findById(account.getEmail());
        System.out.println(account);
        if (accountFound.isPresent()){
            return new ResponseEntity<>("tài khoản đã tồn tại", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.save(account), HttpStatus.OK);
        }
    }
}
