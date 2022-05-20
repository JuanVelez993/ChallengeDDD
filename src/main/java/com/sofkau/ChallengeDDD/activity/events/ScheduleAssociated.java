package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Duration;
import com.sofkau.ChallengeDDD.activity.values.Hour;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class ScheduleAssociated extends DomainEvent {
    private final Schedule_Id entityId;
    private final Hour hour;
    private final Duration duration;
    public ScheduleAssociated(Schedule_Id entityId, Hour hour, Duration duration) {
        super("sofka.activity.scheduleassociated");
        this.entityId=entityId;
        this.hour=hour;
        this.duration=duration;
    }

    public Schedule_Id getEntityId() {
        return entityId;
    }

    public Hour getHour() {
        return hour;
    }

    public Duration getDuration() {
        return duration;
    }
}
