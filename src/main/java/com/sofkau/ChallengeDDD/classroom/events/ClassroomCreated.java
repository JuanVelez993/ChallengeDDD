package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Capacity;
import com.sofkau.ChallengeDDD.group.values.Quotas;

public class ClassroomCreated extends DomainEvent {
    private final Capacity capacity;
    public ClassroomCreated(Capacity capacity) {
        super("sofka.classroom.classroomcreated");
        this.capacity=capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
