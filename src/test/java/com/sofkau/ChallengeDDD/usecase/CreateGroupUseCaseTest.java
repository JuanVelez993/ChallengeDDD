package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.commands.CreateGroup;
import com.sofkau.ChallengeDDD.group.events.GroupCreated;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Quotas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateGroupUseCaseTest {
    @Test

    void createNewGroup(){
        var id = new Group_Id();
        var quota= new Quotas(19);

        var command = new CreateGroup(id,quota);
        var useCase = new CreateGroupUseCase();

        List<DomainEvent> events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        GroupCreated event = (GroupCreated) events.get(0);
        Assertions.assertEquals(19,event.getQuotas().value());
    }

}