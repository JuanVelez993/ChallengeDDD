package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Name;
import com.sofkau.ChallengeDDD.group.values.Specialty;

import java.util.Objects;

public class Instructor extends Entity<Instructor_Id> {
    private  Name name;
    private  Specialty specialty;

    public Instructor(Instructor_Id entityId, Name name, Specialty specialty) {
        super(entityId);
        this.name=name;
        this.specialty=specialty;
    }

    public Name Name() {
        return name;
    }

    public Specialty Specialty() {
        return specialty;
    }

    public void updateName(Name name){
        this.name=Objects.requireNonNull(name);

    }

    public void changeSpecialty(Specialty specialty){
        this.specialty=Objects.requireNonNull(specialty);
    }
}
