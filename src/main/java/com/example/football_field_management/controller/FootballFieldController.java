package com.example.football_field_management.controller;


import com.example.football_field_management.model.*;
import com.example.football_field_management.repositories.AccountRepository;
import com.example.football_field_management.repositories.FootballFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/FootballField")
public class FootballFieldController {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private FootballFieldRepository repositoryFootballField;
    @GetMapping("")
    // this request is : http://localhost:8080/FootballField
    public ResponseEntity<Object> getAllFootballField() {
        return new ResponseEntity<>(repositoryFootballField.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getAccountByUsername(@PathVariable String username){
        Optional<Account> account = repository.findById(username);

        if (account.isPresent()){
            FootballField footballField = repositoryFootballField.findByUsername(username.trim());

            AccountInformation accountInformation = new AccountInformation();
            accountInformation.setUsername(account.get().getUserName());
            accountInformation.setPermission(account.get().isPermission());
            accountInformation.setNameFootballField(footballField.getNameFootballField());
            accountInformation.setNameManage(footballField.getNameManage());
            accountInformation.setTotalYards(footballField.getTotalYards());


            return new ResponseEntity<>(accountInformation,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Username not exists", HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> insertFootballField(@RequestBody FootballField footballField){
        Optional<FootballField> footballFieldFound = repositoryFootballField.findById(footballField.getNameFootballField().trim());

        if (footballFieldFound.isPresent()){
            return new ResponseEntity<>("Name Football Field existed", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repositoryFootballField.save(footballField), HttpStatus.OK);
        }
    }

    @PutMapping("/{nameFootballField}")
    public ResponseEntity<Object> updateFootballField(@PathVariable String nameFootballField, @RequestBody FootballField updateFootballField){
        try {
            System.out.println(nameFootballField);
            Optional<FootballField> footballFieldFound = repositoryFootballField.findById(nameFootballField.trim());

            if (footballFieldFound.isPresent()){
                FootballField footballField = footballFieldFound.get();
                footballField.setNameFootballField(updateFootballField.getNameFootballField());
                footballField.setNameManage(updateFootballField.getNameManage());
                footballField.setTotalYards(updateFootballField.getTotalYards());
                return new ResponseEntity<>(repositoryFootballField.save(footballField), HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
