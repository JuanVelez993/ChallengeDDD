package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.commands.CreateActivity;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;
import com.sofkau.ChallengeDDD.classroom.commands.CreateClassroom;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.classroom.values.Capacity;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.usecase.classroom.CreateClassroomUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateActivityUseCaseTest {

    @Test

    void createNewActivity(){
        var id = new Activity_Id();
        var activity= new Activity_Name("Abdomen");

        var command = new CreateActivity(id,activity);
        var useCase = new CreateActivityUseCase();

        List<DomainEvent> events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ActivityCreated event = (ActivityCreated) events.get(0);
        Assertions.assertEquals("Abdomen",event.getActivity_name().value());
    }

}