package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.classroom.Classroom;
import com.sofkau.ChallengeDDD.classroom.commands.CreateClassroom;



public class CreateClassroomUseCase extends UseCase<RequestCommand<CreateClassroom>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateClassroom> createClassroomRequestCommand) {
        var command = createClassroomRequestCommand.getCommand();
        var classroom= new Classroom(command.getEntityId(),command.getCapacity());



        emit().onResponse(new ResponseEvents(
                classroom.getUncommittedChanges()
        ));

    }
}
