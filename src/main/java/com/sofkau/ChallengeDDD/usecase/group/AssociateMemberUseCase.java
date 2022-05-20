package com.sofkau.ChallengeDDD.usecase.group;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.group.Group;
import com.sofkau.ChallengeDDD.group.commands.AssociateInstructor;
import com.sofkau.ChallengeDDD.group.commands.AssociateMember;

public class AssociateMemberUseCase extends UseCase<RequestCommand<AssociateMember>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssociateMember> associateMemberRequestCommand) {
        var command = associateMemberRequestCommand.getCommand();
        var group = Group.from(
                command.getGroup_id(),
                repository().getEventsBy(command.getGroup_id().value()));

        group.associateMember(command.getMember_id(),command.getName(),command.getMembership());

        emit().onResponse(new ResponseEvents(group.getUncommittedChanges()));
    }
}
