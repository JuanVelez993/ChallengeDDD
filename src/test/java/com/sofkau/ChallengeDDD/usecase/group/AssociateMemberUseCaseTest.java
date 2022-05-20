package com.sofkau.ChallengeDDD.usecase.group;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.commands.AssociateInstructor;
import com.sofkau.ChallengeDDD.group.commands.AssociateMember;
import com.sofkau.ChallengeDDD.group.events.GroupCreated;
import com.sofkau.ChallengeDDD.group.events.InstructorAssociated;
import com.sofkau.ChallengeDDD.group.events.MemberAssociated;
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
class AssociateMemberUseCaseTest {

    @InjectMocks
    private AssociateMemberUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateMemberToGroup(){

        Group_Id group_id = Group_Id.of("grouptestmember");
        Member_Id member_id = new Member_Id();
        Name name = new Name("Juan");
        Membership membership = new Membership("standard");

        var command = new AssociateMember(group_id, member_id, name, membership);

        Mockito.when(repository.getEventsBy("grouptestmember")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getGroup_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (MemberAssociated) events.get(0);
        Assertions.assertEquals("grouptestmember",event.aggregateRootId());
        Assertions.assertEquals("Juan",event.getName().value());
        Assertions.assertEquals("standard",event.getMembership().value());
    }

    private List<DomainEvent> history(){
        var quotas = new Quotas(20);

        var passedEvent = new GroupCreated(
                quotas
        );
       return List.of(passedEvent);
    }

}