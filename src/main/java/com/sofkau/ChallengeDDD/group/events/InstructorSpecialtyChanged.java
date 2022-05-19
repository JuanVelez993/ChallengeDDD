package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Instructor_Id;
import com.sofkau.ChallengeDDD.group.values.Specialty;

public class InstructorSpecialtyChanged extends DomainEvent {
    private final Instructor_Id instructor_id;
    private final Specialty specialty;
    public InstructorSpecialtyChanged(Instructor_Id instructor_id, Specialty specialty) {
        super("sofka.group.instructorspecialtychanged");
        this.instructor_id=instructor_id;
        this.specialty=specialty;
    }

    public Instructor_Id getInstructor_id() {
        return instructor_id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
