package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Capacity;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;

public class CreateClassroom extends Command {
    private final Classroom_Id entityId;
    private final Capacity capacity;

    public CreateClassroom(Classroom_Id entityId, Capacity capacity) {
        this.entityId = entityId;
        this.capacity = capacity;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
