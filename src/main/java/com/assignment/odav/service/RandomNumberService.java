package com.assignment.odav.service;

import com.assignment.odav.RandomNumber;
import com.assignment.odav.repository.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RandomNumberService implements MyRandomNumberService {

    @Autowired
    RandomNumberRepository repository;


    @Override
    public RandomNumber findOrCreateRandom(int id) {
        Optional<RandomNumber> number = repository.findById(id);
        if (number.isEmpty()) { // no random number ressource with that id found
            number = Optional.of(new RandomNumber(id));
            repository.save(number.get());
        }
        return number.get();
    }
}
