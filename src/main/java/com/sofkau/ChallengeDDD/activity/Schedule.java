package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class Schedule extends Entity<Schedule_Id> {

    public Schedule(Schedule_Id entityId) {
        super(entityId);
    }
}
