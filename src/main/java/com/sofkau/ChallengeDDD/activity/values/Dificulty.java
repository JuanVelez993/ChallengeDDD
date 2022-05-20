package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Dificulty implements ValueObject<String> {
    private final String value;

    public Dificulty(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The dificulty can't be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dificulty)) return false;
        Dificulty dificulty = (Dificulty) o;
        return Objects.equals(value, dificulty.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

