package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.group.values.Group_Id;

public class AssociateGroup extends Command {
    private Classroom_Id classroom_id;
    private Group_Id group_id;

    public AssociateGroup(Classroom_Id classroom_id, Group_Id group_id) {
        this.classroom_id = classroom_id;
        this.group_id = group_id;
    }

    public Classroom_Id getClassroom_id() {
        return classroom_id;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }
}
