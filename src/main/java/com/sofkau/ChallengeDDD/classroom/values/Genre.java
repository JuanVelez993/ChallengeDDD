package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genre implements ValueObject<String> {
    private final String value;

    public Genre(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Genre can't be blank");}
    }

    @Override
    public String value() {
        return value;
    }
}
