package com.sofkau.ChallengeDDD.group.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Name;
import com.sofkau.ChallengeDDD.group.values.Specialty;

public class AssociateInstructor extends Command {
    private final Group_Id group_id;
    private final Instructor_Id instructor_id;
    private final Name name;
    private final Specialty specialty;

    public AssociateInstructor(Group_Id group_id, Instructor_Id entityId, Name name, Specialty specialty){
        this.group_id = group_id;
        this.instructor_id=entityId;
        this.name=name;
        this.specialty=specialty;
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

    public Specialty getSpecialty() {
        return specialty;
    }
}
