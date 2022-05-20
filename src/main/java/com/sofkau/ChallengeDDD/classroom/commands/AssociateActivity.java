package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;

public class AssociateActivity extends Command {
    private Classroom_Id classroom_id;
    private Activity_Id activity_id;

    public AssociateActivity(Classroom_Id classroom_id, Activity_Id activity_id) {
        this.classroom_id = classroom_id;
        this.activity_id = activity_id;
    }

    public Classroom_Id getClassroom_id() {
        return classroom_id;
    }

    public Activity_Id getActivity_id() {
        return activity_id;
    }
}
