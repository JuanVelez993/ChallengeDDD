package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.ChallengeDDD.activity.values.Exercises;

import java.util.Objects;

public class Exercises implements ValueObject<Integer> {
    private final Integer value;

    public Exercises(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value<=4){
            throw new IllegalArgumentException("A routine must at least 4 excercises ");
        }
        if(this.value>6){
            throw new IllegalArgumentException("A group can't  have more than 6 excercises");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercises)) return false;
        Exercises exercises = (Exercises) o;
        return Objects.equals(value, exercises.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
