package com.sofkau.ChallengeDDD.activity.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;

public class CreateActivity extends Command {
    private final Activity_Id entityId;
    private final Activity_Name activity_name;

    public CreateActivity(Activity_Id entityId, Activity_Name activity_name) {
        this.entityId = entityId;
        this.activity_name = activity_name;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Activity_Name getActivity_name() {
        return activity_name;
    }
}
