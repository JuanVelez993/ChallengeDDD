package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Hour;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class ScheduleHourChanged extends DomainEvent {
    private final Schedule_Id entityId;
    private final Hour hour;
    public ScheduleHourChanged(Schedule_Id entityId, Hour hour) {
        super("sofka.acitivity.schedulehorchanged");
        this.entityId=entityId;
        this.hour=hour;
    }

    public Schedule_Id getEntityId() {
        return entityId;
    }

    public Hour getHour() {
        return hour;
    }
}
