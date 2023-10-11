package com.example.football_field_management.controller;


import com.example.football_field_management.model.*;
import com.example.football_field_management.repositories.AccountRepository;
import com.example.football_field_management.repositories.ManageInformationRepository;
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
    private AccountRepository accountRepository;
    @Autowired
    private ManageInformationRepository manageInformationRepository;
    @GetMapping("")
    // this request is : http://localhost:8080/FootballField
    public ResponseEntity<Object> getAllFootballField() {
        return new ResponseEntity<>(manageInformationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getInformationByUsername(@PathVariable String username){
        Optional<ManageInformation> manageInformationFound = manageInformationRepository.findById(username.trim());


        if (manageInformationFound.isPresent()){

            ManageInformation manageInformation = new ManageInformation();
            manageInformation.setUsername(manageInformationFound.get().getUsername());
            manageInformation.setPermission(manageInformationFound.get().isPermission());
            manageInformation.setNameFootballField(manageInformationFound.get().getNameFootballField());
            manageInformation.setNameManage(manageInformationFound.get().getNameManage());
            manageInformation.setTotalYards(manageInformationFound.get().getTotalYards());


            return new ResponseEntity<>(manageInformation,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("không tìm thấy tài khoản", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getInformationByNameFootballField(@RequestParam(value = "nameFootballField") String nameFootballField){
        ManageInformation manageInformationFound = manageInformationRepository.findByNameFootballField(nameFootballField);

        return new ResponseEntity<>(manageInformationFound, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> insertFootballField(@RequestBody ManageInformation manageInformation){
        return new ResponseEntity<>(manageInformationRepository.save(manageInformation), HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Object> updateFootballField(@PathVariable String username, @RequestBody ManageInformation updateManageInformation){
        try {
            Optional<ManageInformation> manageInformationFound = manageInformationRepository.findById(username.trim());

            if (manageInformationFound.isPresent()){
                ManageInformation manageInformation = manageInformationFound.get();
                manageInformation.setNameFootballField(updateManageInformation.getNameFootballField());
                manageInformation.setNameManage(updateManageInformation.getNameManage());
                manageInformation.setTotalYards(updateManageInformation.getTotalYards());
                return new ResponseEntity<>(manageInformationRepository.save(manageInformation), HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
