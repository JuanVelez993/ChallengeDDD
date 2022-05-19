package com.sofkau.ChallengeDDD.group.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Name;

public class UpdateInstructorName extends Command {
    private final Group_Id group_id;
    private final Instructor_Id instructor_id;
    private final Name name;

    public UpdateInstructorName(Group_Id group_id, Instructor_Id instructor_id, Name name) {
        this.group_id = group_id;
        this.instructor_id = instructor_id;
        this.name = name;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }

    public Instructor_Id getInstructor_id() {
        return instructor_id;
    }

    public Name getName() {
        return name;
    }
}
