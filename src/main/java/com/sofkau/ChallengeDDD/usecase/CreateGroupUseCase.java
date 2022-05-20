package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.group.Group;
import com.sofkau.ChallengeDDD.group.commands.CreateGroup;

public class CreateGroupUseCase extends UseCase<RequestCommand<CreateGroup>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateGroup> createGroupRequestCommand) {
        var command = createGroupRequestCommand.getCommand();
        var group= new Group(command.getGroup_id(),command.getQuotas());



        emit().onResponse(new ResponseEvents(
                group.getUncommittedChanges() //gives me the changes that are not confirmed yet
        ));
    }
}
