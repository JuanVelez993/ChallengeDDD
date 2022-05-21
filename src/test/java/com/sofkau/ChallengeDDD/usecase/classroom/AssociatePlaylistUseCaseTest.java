package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.commands.AssociatePlaylist;
import com.sofkau.ChallengeDDD.classroom.events.ClassroomCreated;
import com.sofkau.ChallengeDDD.classroom.events.PlaylistAssociated;
import com.sofkau.ChallengeDDD.classroom.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AssociatePlaylistUseCaseTest {

    @InjectMocks
    private AssociatePlaylistUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateInstructorToGroup(){

        Classroom_Id classroom_id = Classroom_Id.of("someclassroom");
        Playlist_Id playlist_id= new Playlist_Id();
        Songs songs = new Songs(6);
        Genre genre = new Genre("Electro");

        var command = new AssociatePlaylist(classroom_id, playlist_id, songs, genre);

        Mockito.when(repository.getEventsBy("someclassroom")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (PlaylistAssociated) events.get(0);
        Assertions.assertEquals("someclassroom",event.aggregateRootId());
        Assertions.assertEquals(6,event.getSongs().value());
        Assertions.assertEquals("Electro",event.getGenre().value());
    }

    private List<DomainEvent> history(){
        var capacity = new Capacity(20);

        var passedEvent = new ClassroomCreated(
                capacity
        );

        return List.of(passedEvent);
    }

}