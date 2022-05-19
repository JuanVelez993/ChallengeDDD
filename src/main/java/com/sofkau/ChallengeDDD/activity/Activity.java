package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;

public class Activity extends AggregateEvent<Activity_Id> {

    public Activity(Activity_Id entityId) {
        super(entityId);
    }
}
