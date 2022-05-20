package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Brand implements ValueObject<String> {
    private final String value;

    public Brand(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Brand can't be blank");
    }
    }


    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(value, brand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
