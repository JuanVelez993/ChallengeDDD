package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class Routine extends Entity<Routine_Id> {

    public Routine(Routine_Id entityId) {
        super(entityId);
    }
}
