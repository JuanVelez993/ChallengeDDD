package com.sofkau.ChallengeDDD.usecase.activity;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.activity.Activity;
import com.sofkau.ChallengeDDD.activity.commands.CreateActivity;



public class CreateActivityUseCase extends UseCase<RequestCommand<CreateActivity>, ResponseEvents> {
        @Override
        public void executeUseCase(RequestCommand<CreateActivity> createActivityRequestCommand) {
            var command = createActivityRequestCommand.getCommand();
            var activity= new Activity(command.getEntityId(),command.getActivity_name());



            emit().onResponse(new ResponseEvents(
                    activity.getUncommittedChanges()
            ));

        }

    }

