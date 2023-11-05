package com.example.football_field_management.controller;

import com.example.football_field_management.model.*;
import com.example.football_field_management.repositories.AccountRepository;
import com.example.football_field_management.repositories.FootballFieldInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/footballFieldInformation")
public class FootballFieldInformationController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FootballFieldInformationRepository footballFieldInformationRepository;
    @GetMapping("")
    // this request is : http://localhost:8080/FootballField
    public ResponseEntity<Object> getAllFootballField() {
        return new ResponseEntity<>(footballFieldInformationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> getInformationByEmail(@PathVariable String email){
        Optional<FootballFieldInformation> manageInformationFound = footballFieldInformationRepository.findById(email.trim());


        if (manageInformationFound.isPresent()){

            FootballFieldInformation footballFieldInformation = new FootballFieldInformation();
            footballFieldInformation.setEmail(manageInformationFound.get().getEmail());
            footballFieldInformation.setPermission(manageInformationFound.get().isPermission());
            footballFieldInformation.setNameFootballField(manageInformationFound.get().getNameFootballField());
            footballFieldInformation.setNameManager(manageInformationFound.get().getNameManager());
            footballFieldInformation.setTotalYards(manageInformationFound.get().getTotalYards());


            return new ResponseEntity<>(footballFieldInformation,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("không tìm thấy tài khoản", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getInformationByNameFootballField(@RequestParam(value = "nameFootballField") String nameFootballField){
        FootballFieldInformation footballFieldInformationFound = footballFieldInformationRepository.findByNameFootballField(nameFootballField);

        return new ResponseEntity<>(footballFieldInformationFound, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> insertFootballField(@RequestBody FootballFieldInformation footballFieldInformation){
        return new ResponseEntity<>(footballFieldInformationRepository.save(footballFieldInformation), HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> updateFootballField(@PathVariable String email, @RequestBody FootballFieldInformation updateFootballFieldInformation){
        try {
            Optional<FootballFieldInformation> manageInformationFound = footballFieldInformationRepository.findById(email.trim());

            if (manageInformationFound.isPresent()){
                FootballFieldInformation footballFieldInformation = manageInformationFound.get();
                footballFieldInformation.setNameFootballField(updateFootballFieldInformation.getNameFootballField());
                footballFieldInformation.setNameManager(updateFootballFieldInformation.getNameManager());
                footballFieldInformation.setTotalYards(updateFootballFieldInformation.getTotalYards());
                return new ResponseEntity<>(footballFieldInformationRepository.save(footballFieldInformation), HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
