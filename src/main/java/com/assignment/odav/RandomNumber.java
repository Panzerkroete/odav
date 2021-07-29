package com.assignment.odav;


import lombok.Data;

import java.util.Objects;

@Data
public class RandomNumber {

    /**
     * id of the ressource
     */
    private int id;

    /**
     * Corresponding random number of the resource
     */
    private double random;

    public RandomNumber(Integer id) {
        this.id = id;
        random = Math.random();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
