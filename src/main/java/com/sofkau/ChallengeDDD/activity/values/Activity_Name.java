package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Activity_Name implements ValueObject<String> {
    private final String value;

    public Activity_Name(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The Activity name can't be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity_Name)) return false;
        Activity_Name activity_name = (Activity_Name) o;
        return Objects.equals(value, activity_name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
