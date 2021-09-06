package com.pureIntegration.dog.controller;

import com.pureIntegration.dog.Model.Dog;
import com.pureIntegration.dog.service.DogService;
import com.pureIntegration.dog.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/breeds")
public class DogController {

    @Autowired
    DogServiceImpl dogService;

    @GetMapping("/list")
    public ResponseEntity<?> getDogs() throws IOException {
        Dog dog =dogService.getDogs();
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDog( @RequestBody Dog newDog) throws IOException {
        Dog dog =dogService.addDog(newDog);
        return new ResponseEntity<>(dog, HttpStatus.CREATED);
    }
}
