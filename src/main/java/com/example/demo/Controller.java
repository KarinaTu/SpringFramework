package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/user")
public class Controller {

    @GetMapping("")
    public double getRandomNumber () {
        return Math.random() * 100;
    }

    @GetMapping("/square/{value}")
    public double getNumberAndReturnSquare(@PathVariable("value")double value){
        System.out.println("You have requested this parameter:" + value);
        return value * value;
    }

    @GetMapping("/verify/{value}")
    public ResponseEntity<String> verifyNumber(@PathVariable("value") int value){
        System.out.println("value" + value);
        if (value > 0){
            return ResponseEntity.ok(String.valueOf(value));
        } else {
            return new ResponseEntity<>("Value should be positive", HttpStatus.BAD_REQUEST);
        }
    }
    }




