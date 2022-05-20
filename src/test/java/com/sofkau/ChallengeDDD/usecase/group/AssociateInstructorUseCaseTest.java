package com.sofkau.ChallengeDDD.usecase.group;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.commands.AssociateInstructor;
import com.sofkau.ChallengeDDD.group.events.GroupCreated;
import com.sofkau.ChallengeDDD.group.events.InstructorAssociated;
import com.sofkau.ChallengeDDD.group.values.*;
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
class AssociateInstructorUseCaseTest {

    @InjectMocks
    private AssociateInstructorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateInstructorToGroup(){

        Group_Id group_id = Group_Id.of("somegroup");
        Instructor_Id instructor_id = new Instructor_Id();
        Name name = new Name("Jorge");
        Specialty specialty = new Specialty("Cardio");

        var command = new AssociateInstructor(group_id, instructor_id, name, specialty);

        Mockito.when(repository.getEventsBy("somegroup")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getGroup_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (InstructorAssociated) events.get(0);
        Assertions.assertEquals("somegroup",event.aggregateRootId());
        Assertions.assertEquals("Jorge",event.getName().value());
        Assertions.assertEquals("Cardio",event.getSpecialty().value());
    }

    private List<DomainEvent> history(){
        var quotas = new Quotas(20);

        var passedEvent = new GroupCreated(
                quotas
        );
        //passedEvent.setAggregateRootId("xxxx");
        return List.of(passedEvent);
    }

}