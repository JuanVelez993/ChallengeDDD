package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.classroom.Classroom;
import com.sofkau.ChallengeDDD.classroom.commands.UpdateEquipmentBrand;

public class UpdateEquipmentBrandUseCase extends UseCase<RequestCommand<UpdateEquipmentBrand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateEquipmentBrand> updateEquipmentBrandRequestCommand) {
        var command = updateEquipmentBrandRequestCommand.getCommand();

        var classroom = Classroom.from(command.getEntityId(), retrieveEvents(command.getEntityId().value()));
        classroom.updateEquipmentBrand(command.getEquipment_id(),command.getBrand());

        emit().onResponse(new ResponseEvents(classroom.getUncommittedChanges()));
    }
}
