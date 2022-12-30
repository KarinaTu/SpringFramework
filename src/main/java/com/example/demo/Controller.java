package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    CalcService service;

    @GetMapping("/random")
    public double getRandomNumber() {
        return service.generateRandom();
//        return Math.random() * 100;
    }

    @PostMapping("/random")
    public double postRandomNumber() {
        return service.generateRandom();
//        return Math.random() * 100;
    }

    @GetMapping("/square/{value}")
    public double getNumberAndReturnSquare(@PathVariable("value") double value) {
        System.out.println("You have requested this parameter:" + value);
//        return value * value;
        return service.calcSquare(value);
    }

    @GetMapping("/verify/{value}")
    public ResponseEntity<String> verifyNumber(@PathVariable("value") int value) {
        System.out.println("value" + value);
        if (value > 0) {
            return ResponseEntity.ok(String.valueOf(value));
        } else {
            return new ResponseEntity<>("Value should be positive", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sum/{valueone}/{valuetwo}")
    public double getSum(@PathVariable("valueone") double a, @PathVariable("valuetwo") double b) {
        System.out.println("You have requested this parameter: " + a);
        System.out.println("You have requested this parameter: " + b);
        return (a + b);
    }


}




