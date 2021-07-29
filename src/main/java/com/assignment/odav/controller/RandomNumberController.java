package com.assignment.odav.controller;

import com.assignment.odav.RandomNumber;
import com.assignment.odav.service.MyRandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

    @Autowired
    private MyRandomNumberService service;


    @GetMapping(value = "/random/{randomId}")
    public @ResponseBody
    RandomNumber getData(@PathVariable int randomId) {
        return service.findOrCreateRandom(randomId);
    }

}


