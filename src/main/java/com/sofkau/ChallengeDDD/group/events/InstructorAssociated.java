package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Name;
import com.sofkau.ChallengeDDD.group.values.Specialty;

public class InstructorAssociated extends DomainEvent {
    private final Instructor_Id instructor_id;
    private final Name name;
    private Specialty specialty;
    public InstructorAssociated(Instructor_Id entityId, Name name, Specialty specialty) {
        super("sofka.group.instructorassociated");
        this.instructor_id=entityId;
        this.name=name;
        this.specialty=specialty;
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
