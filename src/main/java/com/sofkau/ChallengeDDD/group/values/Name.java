package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");

        }
        if(this.value.length()<4){
            throw new IllegalArgumentException("A name must have more than 4 characters ");
        }
        if(this.value.length()>=100){
            throw new IllegalArgumentException("A name must be less than 150 characters");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
