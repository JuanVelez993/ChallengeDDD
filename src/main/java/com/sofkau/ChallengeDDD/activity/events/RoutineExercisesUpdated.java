package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Exercises;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class RoutineExercisesUpdated extends DomainEvent {
    private final Routine_Id entityId;
    private final Exercises exercises;
    public RoutineExercisesUpdated(Routine_Id entityId, Exercises exercises) {
        super("sofka.activity.routineexercisesupdated");
        this.entityId=entityId;
        this.exercises=exercises;
    }

    public Routine_Id getEntityId() {
        return entityId;
    }

    public Exercises getExercises() {
        return exercises;
    }
}
