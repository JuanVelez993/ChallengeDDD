package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Capacity;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;

public class CapacityUpdated extends DomainEvent {
    private final Classroom_Id entityId;
    private final Capacity capacity;
    public CapacityUpdated(Classroom_Id entityId, Capacity capacity) {
        super("sofka.classroom.capacityupdated");
        this.entityId=entityId;
        this.capacity=capacity;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
