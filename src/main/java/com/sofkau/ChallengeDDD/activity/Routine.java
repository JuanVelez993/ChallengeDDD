package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.activity.values.Dificulty;
import com.sofkau.ChallengeDDD.activity.values.Exercises;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;
import com.sofkau.ChallengeDDD.group.values.Name;

import java.util.Objects;

public class Routine extends Entity<Routine_Id> {
    private Exercises exercises;
    private Dificulty dificulty;

    public Routine(Routine_Id entityId,Exercises exercises,Dificulty dificulty) {
        super(entityId);
        this.exercises=exercises;
        this.dificulty=dificulty;
    }

    public Exercises Exercises() {
        return exercises;
    }

    public Dificulty Dificulty() {
        return dificulty;
    }

    public void updateExercises(Exercises exercises){
        this.exercises= Objects.requireNonNull(exercises);

    }

    public void updateDificulty(Dificulty dificulty){
        this.dificulty= Objects.requireNonNull(dificulty);

    }
}
