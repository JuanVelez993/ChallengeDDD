package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.activity.events.NotificationSent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Name;
import com.sofkau.ChallengeDDD.group.events.EmailSent;
import com.sofkau.ChallengeDDD.group.events.GroupCreated;
import com.sofkau.ChallengeDDD.group.values.Quotas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SendEmailToInstructorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void sendEmailToInstructor(){
        var event = new GroupCreated(new Quotas(25));

        event.setAggregateRootId("newgroup");
        var useCase = new SendEmailToInstructorUseCase();

        Mockito.when(repository.getEventsBy("newgroup")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("newgroup")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while sending the email"))
                .getDomainEvents();

        var email = (EmailSent) events.get(0);
        Assertions.assertEquals("A new group has been created,please check to see if you are assigned", email.getEmail());
        Mockito.verify(repository).getEventsBy("newgroup");
    }
}