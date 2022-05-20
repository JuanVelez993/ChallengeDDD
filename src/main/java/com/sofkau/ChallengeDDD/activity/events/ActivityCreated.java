package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;

public class ActivityCreated extends DomainEvent {
    private final Activity_Name activity_name;
    public ActivityCreated(Activity_Name activity_name) {
        super("sofka.activity.activitycreated");
        this.activity_name=activity_name;
    }

    public Activity_Name getActivity_name() {
        return activity_name;
    }
}
