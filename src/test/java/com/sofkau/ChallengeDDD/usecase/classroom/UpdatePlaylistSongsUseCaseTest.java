package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.ChallengeDDD.classroom.commands.UpdatePlaylistSongs;
import com.sofkau.ChallengeDDD.classroom.events.ClassroomCreated;
import com.sofkau.ChallengeDDD.classroom.events.PlaylistAssociated;
import com.sofkau.ChallengeDDD.classroom.events.PlaylistSongsUpdated;
import com.sofkau.ChallengeDDD.classroom.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdatePlaylistSongsUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdatePlaylistSongs() {

        Classroom_Id classroom_id = Classroom_Id.of("classwithplaylist");
        Playlist_Id playlist_id = Playlist_Id.of("moresongs");
        Songs songs = new Songs(4);

        var command = new UpdatePlaylistSongs(classroom_id, playlist_id, songs);
        var useCase = new UpdatePlaylistSongsUseCase();

        Mockito.when(repository.getEventsBy("classwithplaylist")).thenReturn(List.of(
                new ClassroomCreated(
                        new Capacity(15)
                ),
                new PlaylistAssociated(Playlist_Id.of("moresongs"),
                        new Songs(3),
                        new Genre("Lofi")

                )));

        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("classwithplaylist")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while updating the songs"))
                .getDomainEvents();


        var event = (PlaylistSongsUpdated) events.get(0);
        Assertions.assertEquals(4,event.getSongs().value());
        Mockito.verify(repository).getEventsBy("classwithplaylist");
    }

}