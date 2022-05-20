package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Dificulty;
import com.sofkau.ChallengeDDD.activity.values.Exercises;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class RoutineAssociated extends DomainEvent {
    private final Routine_Id entityId;
    private final Exercises exercises;
    private final Dificulty dificulty;
    public RoutineAssociated(Routine_Id entityId, Exercises exercises, Dificulty dificulty) {
        super("sofka.activity.routineassociated");
        this.entityId=entityId;
        this.exercises=exercises;
        this.dificulty=dificulty;
    }

    public Routine_Id getEntityId() {
        return entityId;
    }

    public Exercises getExercises() {
        return exercises;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }
}
