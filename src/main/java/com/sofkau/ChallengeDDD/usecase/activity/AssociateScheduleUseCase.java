package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.activity.Activity;
import com.sofkau.ChallengeDDD.activity.commands.AssociateSchedule;

public class AssociateScheduleUseCase extends UseCase<RequestCommand<AssociateSchedule>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssociateSchedule> associateScheduleRequestCommand) {
        var command = associateScheduleRequestCommand.getCommand();
        var activity = Activity.from(
                command.getEntityId(),
                repository().getEventsBy(command.getEntityId().value()));

        activity.associateSchedule(command.getSchedule_id(),command.getHour(),command.getDuration());

        emit().onResponse(new ResponseEvents(activity.getUncommittedChanges()));
    }
}