package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.commands.AssociateRoutine;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.activity.events.RoutineAssociated;
import com.sofkau.ChallengeDDD.activity.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AssociateRoutineUseCaseTest {

    @InjectMocks
    private AssociateRoutineUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateRoutineToActivity(){

        Activity_Id activity_id= Activity_Id.of("activitytest");
        Routine_Id routine_id = new Routine_Id();
        Exercises exercises = new Exercises(5);
        Dificulty dificulty = new Dificulty("Beginner");

        var command = new AssociateRoutine(activity_id, routine_id, exercises, dificulty);

        Mockito.when(repository.getEventsBy("activitytest")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (RoutineAssociated) events.get(0);
        Assertions.assertEquals("activitytest",event.aggregateRootId());
        Assertions.assertEquals(5,event.getExercises().value());
        Assertions.assertEquals("Beginner",event.getDificulty().value());
    }

    private List<DomainEvent> history(){
        var activity_name = new Activity_Name("Spinning");

        var passedEvent = new ActivityCreated(
                activity_name
        );
        return List.of(passedEvent);
    }

}