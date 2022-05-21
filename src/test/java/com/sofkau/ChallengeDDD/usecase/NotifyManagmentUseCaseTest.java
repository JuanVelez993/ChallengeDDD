package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.activity.events.NotificationSent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class NotifyManagmentUseCaseTest  {
    @Mock
    private DomainEventRepository repository;

    @Test
    void sendEmailToClient(){
        var event = new ActivityCreated(new Activity_Name("weight lifting basics"));

        event.setAggregateRootId("newactivity");
        var useCase = new NotifyManagmentUseCase();

        Mockito.when(repository.getEventsBy("newactivity")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("newactivity")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while sending the notification"))
                .getDomainEvents();

        var notification = (NotificationSent) events.get(0);
        Assertions.assertEquals("The Activity has been create,please notify Managment so they can offer them to the members", notification.getNote());
        Mockito.verify(repository).getEventsBy("newactivity");
    }
}