package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Duration implements ValueObject<String> {
    private final String value;

    public Duration(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The duration can't be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duration)) return false;
        Duration duration = (Duration) o;
        return Objects.equals(value, duration.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
