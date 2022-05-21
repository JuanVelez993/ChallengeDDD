package com.sofkau.ChallengeDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.ChallengeDDD.activity.Activity;
import com.sofkau.ChallengeDDD.activity.events.ActivityCreated;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;


public class NotifyManagmentUseCase extends UseCase<TriggeredEvent<ActivityCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ActivityCreated> activityCreatedTriggeredEvent) {
        var event = activityCreatedTriggeredEvent.getDomainEvent();
        var activity= Activity.from(Activity_Id.of(event.aggregateRootId()),this.retrieveEvents());
        activity.notifyManagment("The Activity has been create,please notify Managment so they can offer them to the members");



        emit().onResponse(new ResponseEvents(
                activity.getUncommittedChanges()
        ));
    }
}
