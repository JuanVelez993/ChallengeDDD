package com.sofkau.ChallengeDDD.activity.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Exercises;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class UpdateRoutineExercises extends Command {
    private final Activity_Id entityId;
    private final Routine_Id routine_id;
    private final Exercises exercises;

    public UpdateRoutineExercises(Activity_Id entityId, Routine_Id routine_id, Exercises exercises) {
        this.entityId = entityId;
        this.routine_id = routine_id;
        this.exercises = exercises;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Routine_Id getRoutine_id() {
        return routine_id;
    }

    public Exercises getExercises() {
        return exercises;
    }
}
