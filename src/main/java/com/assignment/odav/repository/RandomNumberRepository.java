package com.assignment.odav.repository;

import com.assignment.odav.RandomNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class RandomNumberRepository implements CrudRepository<RandomNumber, Integer> {

    private final HashMap<Integer, RandomNumber> storageMap = new HashMap<>();

    @Override
    public <S extends RandomNumber> S save(S s) {
        storageMap.putIfAbsent(s.getId(), s);
        return s;
    }

    @Override
    public <S extends RandomNumber> Iterable<S> saveAll(Iterable<S> iterable) {
        for (RandomNumber random : iterable) {
            save(random);
        }
        return iterable;
    }

    @Override
    public Optional<RandomNumber> findById(Integer id) {
        return Optional.ofNullable(storageMap.get(id));
    }

    @Override
    public boolean existsById(Integer id) {
        return storageMap.containsKey(id);
    }

    @Override
    public Iterable<RandomNumber> findAll() {
        return (Iterable<RandomNumber>) storageMap.entrySet().iterator();
    }

    @Override
    public Iterable<RandomNumber> findAllById(Iterable<Integer> iterable) {
        List<RandomNumber> results = new ArrayList<>();

        for (Integer id : iterable) {
            findById(id).ifPresent(results::add);
        }
        return results;
    }

    @Override
    public long count() {
        return storageMap.size();
    }

    @Override
    public void deleteById(Integer id) {
        storageMap.remove(id);
    }

    @Override
    public void delete(RandomNumber randomNumber) {
        storageMap.remove(randomNumber.getId(), randomNumber);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {
        for (Integer id : iterable) {
            deleteById(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends RandomNumber> iterable) {
        for (RandomNumber number : iterable) {
            storageMap.remove(number);
        }
    }

    @Override
    public void deleteAll() {
        storageMap.clear();
    }
}
