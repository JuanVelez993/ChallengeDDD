package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Equipment_type implements ValueObject<String> {
    private final String value;

    public Equipment_type(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Type can't be blank");

        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment_type)) return false;
        Equipment_type equipment_type = (Equipment_type) o;
        return Objects.equals(value, equipment_type.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
