package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.ChallengeDDD.classroom.Classroom;
import com.sofkau.ChallengeDDD.classroom.commands.UpdatePlaylistSongs;

public class UpdatePlaylistSongsUseCase extends UseCase<RequestCommand<UpdatePlaylistSongs>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePlaylistSongs> updatePlaylistSongsRequestCommand) {
        var command = updatePlaylistSongsRequestCommand.getCommand();

        var classroom = Classroom.from(command.getEntityId(), retrieveEvents(command.getEntityId().value()));
        classroom.updatePlaylistSongs(command.getPlaylist_id(),command.getSongs());

        emit().onResponse(new ResponseEvents(classroom.getUncommittedChanges()));
    }
}