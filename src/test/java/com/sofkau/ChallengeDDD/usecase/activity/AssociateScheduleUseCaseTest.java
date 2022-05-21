package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.commands.AssociateRoutine;
import com.sofkau.ChallengeDDD.activity.commands.AssociateSchedule;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.activity.events.RoutineAssociated;
import com.sofkau.ChallengeDDD.activity.events.ScheduleAssociated;
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
class AssociateScheduleUseCaseTest {

    @InjectMocks
    private AssociateScheduleUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateScheduleToActivity(){

        Activity_Id activity_id= Activity_Id.of("activityscheduling");
        Schedule_Id schedule_id = new Schedule_Id();
        Hour hour = new Hour("2pm");
        Duration duration = new Duration("2 Hours");

        var command = new AssociateSchedule(activity_id, schedule_id, hour, duration);

        Mockito.when(repository.getEventsBy("activityscheduling")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (ScheduleAssociated) events.get(0);
        Assertions.assertEquals("activityscheduling",event.aggregateRootId());
        Assertions.assertEquals("2pm",event.getHour().value());
        Assertions.assertEquals("2 Hours",event.getDuration().value());
    }

    private List<DomainEvent> history(){
        var activity_name = new Activity_Name("Combat");

        var passedEvent = new ActivityCreated(
                activity_name
        );
        return List.of(passedEvent);
    }

}