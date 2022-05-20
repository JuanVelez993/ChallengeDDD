package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.commands.CreateClassroom;
import com.sofkau.ChallengeDDD.classroom.values.Capacity;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.events.ClassroomCreated;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateClassroomUseCaseTest {
    @Test

    void createNewClassroom(){
        var id = new Classroom_Id();
        var capacity= new Capacity(19);

        var command = new CreateClassroom(id,capacity);
        var useCase = new CreateClassroomUseCase();

        List<DomainEvent> events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ClassroomCreated event = (ClassroomCreated) events.get(0);
        Assertions.assertEquals(19,event.getCapacity().value());
    }



}