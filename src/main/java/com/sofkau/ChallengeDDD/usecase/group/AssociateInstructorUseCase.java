package com.sofkau.ChallengeDDD.usecase.group;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.group.Group;
import com.sofkau.ChallengeDDD.group.commands.AssociateInstructor;

public class AssociateInstructorUseCase extends UseCase<RequestCommand<AssociateInstructor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssociateInstructor> associateInstructorRequestCommand) {
        var command = associateInstructorRequestCommand.getCommand();
        var group = Group.from(
                command.getGroup_id(),
                repository().getEventsBy(command.getGroup_id().value()));

        group.associateInstructor(command.getInstructor_id(),command.getName(),command.getSpecialty());

        emit().onResponse(new ResponseEvents(group.getUncommittedChanges()));
    }
}