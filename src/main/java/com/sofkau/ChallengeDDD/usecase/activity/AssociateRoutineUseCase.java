package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.activity.Activity;
import com.sofkau.ChallengeDDD.activity.commands.AssociateRoutine;


public class AssociateRoutineUseCase extends UseCase<RequestCommand<AssociateRoutine>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssociateRoutine> associateRoutineRequestCommand) {
        var command = associateRoutineRequestCommand.getCommand();
        var activity = Activity.from(
                command.getEntityId(),
                repository().getEventsBy(command.getEntityId().value()));

        activity.associateRoutine(command.getRoutine_id(),command.getExercises(),command.getDificulty());

        emit().onResponse(new ResponseEvents(activity.getUncommittedChanges()));
    }
}
