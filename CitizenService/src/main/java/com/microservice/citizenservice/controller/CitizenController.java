package com.microservice.citizenservice.controller;

import com.microservice.citizenservice.entity.Citizen;
import com.microservice.citizenservice.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository repo;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> callMethod(){
        return  new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
        List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
        return  new ResponseEntity<>(listCitizen, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
        Citizen citizen = repo.save(newCitizen);
        return  new ResponseEntity<>(citizen, HttpStatus.OK);
    }

}
