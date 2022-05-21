package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.classroom.Classroom;
import com.sofkau.ChallengeDDD.classroom.commands.AssociatePlaylist;


public class AssociatePlaylistUseCase extends UseCase<RequestCommand<AssociatePlaylist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssociatePlaylist> associatePlaylistRequestCommand) {
        var command = associatePlaylistRequestCommand.getCommand();
        var classroom = Classroom.from(
                command.getEntityId(),
                repository().getEventsBy(command.getEntityId().value()));

        classroom.associatePlaylist(command.getPlaylist_id(),command.getSongs(),command.getGenre());

        emit().onResponse(new ResponseEvents(classroom.getUncommittedChanges()));
    }
}
