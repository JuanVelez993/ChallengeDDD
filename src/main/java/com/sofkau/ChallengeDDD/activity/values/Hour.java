package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Hour implements ValueObject<String> {
    private final String value;

    public Hour(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The Hour can't be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hour)) return false;
        Hour hour = (Hour) o;
        return Objects.equals(value, hour.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

