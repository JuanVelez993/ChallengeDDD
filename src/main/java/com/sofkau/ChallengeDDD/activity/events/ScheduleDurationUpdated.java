package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Duration;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class ScheduleDurationUpdated extends DomainEvent {
    private final Schedule_Id entityId;
    private final Duration duration;
    public ScheduleDurationUpdated(Schedule_Id entityId, Duration duration) {
        super("sofka.activity.scheduledurationupdated");
        this.entityId=entityId;
        this.duration=duration;
    }

    public Schedule_Id getEntityId() {
        return entityId;
    }

    public Duration getDuration() {
        return duration;
    }
}
