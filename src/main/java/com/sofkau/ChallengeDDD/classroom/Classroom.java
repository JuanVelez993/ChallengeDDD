package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;

public class Classroom extends AggregateEvent<Classroom_Id> {

    public Classroom(Classroom_Id entityId) {
        super(entityId);
    }
}
