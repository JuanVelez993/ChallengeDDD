package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;

public class ActivityAssociated extends DomainEvent {
    private final Activity_Id activity_id;
    public ActivityAssociated(Activity_Id activity_id) {
        super("sofka.classroom.activityassociated");
        this.activity_id=activity_id;
    }

    public Activity_Id getActivity_id() {
        return activity_id;
    }
}
