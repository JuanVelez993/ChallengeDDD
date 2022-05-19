package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Membership implements ValueObject<String> {
    private final String value;

    public Membership(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The membership can't be blank");
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membership)) return false;
        Membership membership = (Membership) o;
        return Objects.equals(value, membership.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
