package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;

public class Activity_NameChanged extends DomainEvent {
    private final Activity_Id entityId;
    private final Activity_Name activity_name;
    public Activity_NameChanged(Activity_Id entityId, Activity_Name activity_name) {
        super("sofka.activity.activitynamechanged");
        this.entityId=entityId;
        this.activity_name=activity_name;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Activity_Name getActivity_name() {
        return activity_name;
    }
}
