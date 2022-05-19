package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Name;

public class InstructorNameUpdated extends DomainEvent {
    private final Instructor_Id instructor_id;
    private final Name name;
    public InstructorNameUpdated(Instructor_Id entityId, Name name) {
        super("sofka.group.instructornameupdated");
        this.instructor_id=entityId;
        this.name=name;
    }

    public Instructor_Id getInstructor_id() {
        return instructor_id;
    }

    public Name getName() {
        return name;
    }
}
