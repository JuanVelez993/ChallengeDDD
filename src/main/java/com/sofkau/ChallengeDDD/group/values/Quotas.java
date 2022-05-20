package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Quotas implements ValueObject<Integer> {
    private final Integer value;

    public Quotas(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value<=10){
            throw new IllegalArgumentException("A group must at least 10 quotas ");
        }
        if(this.value>=30){
            throw new IllegalArgumentException("A group can't  have more than 30 quotas");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quotas)) return false;
        Quotas quotas = (Quotas) o;
        return Objects.equals(value, quotas.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
