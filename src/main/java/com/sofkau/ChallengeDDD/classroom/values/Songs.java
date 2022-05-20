package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Songs implements ValueObject<Integer> {
    private final Integer value;

    public Songs(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value>=15){
            throw new IllegalArgumentException("A playlist can't  have more than 15 songs");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Songs)) return false;
        Songs songs = (Songs) o;
        return Objects.equals(value, songs.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
