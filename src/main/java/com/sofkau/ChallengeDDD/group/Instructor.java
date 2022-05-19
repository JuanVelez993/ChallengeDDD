package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;

public class Instructor extends Entity<Instructor_Id> {

    public Instructor(Instructor_Id entityId) {
        super(entityId);
    }
}
