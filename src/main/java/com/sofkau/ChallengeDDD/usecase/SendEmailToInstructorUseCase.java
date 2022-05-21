package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.ChallengeDDD.group.Group;
import com.sofkau.ChallengeDDD.group.events.GroupCreated;
import com.sofkau.ChallengeDDD.group.values.Group_Id;

public class SendEmailToInstructorUseCase extends UseCase<TriggeredEvent<GroupCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<GroupCreated> groupCreatedTriggeredEvent) {
        var event = groupCreatedTriggeredEvent.getDomainEvent();
        var group= Group.from(Group_Id.of(event.aggregateRootId()),this.retrieveEvents());
        group.sendEmailToInstructor("A new group has been created,please check to see if you are assigned");



        emit().onResponse(new ResponseEvents(
                group.getUncommittedChanges()
        ));
    }
}
