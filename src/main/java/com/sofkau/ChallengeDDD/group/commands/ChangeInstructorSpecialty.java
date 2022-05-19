package com.sofkau.ChallengeDDD.group.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Specialty;

public class ChangeInstructorSpecialty extends Command {
    private final Group_Id group_id;
    private final Instructor_Id instructor_id;
    private final Specialty specialty;

    public ChangeInstructorSpecialty(Group_Id group_id, Instructor_Id instructor_id, Specialty specialty) {
        this.group_id = group_id;
        this.instructor_id = instructor_id;
        this.specialty = specialty;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }

    public Instructor_Id getInstructor_id() {
        return instructor_id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
