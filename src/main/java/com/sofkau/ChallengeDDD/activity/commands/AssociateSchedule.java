package com.sofkau.ChallengeDDD.activity.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Duration;
import com.sofkau.ChallengeDDD.activity.values.Hour;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class AssociateSchedule extends Command {
    private final Activity_Id entityId;
    private final Schedule_Id schedule_id;
    private final Hour hour;
    private final Duration duration;

    public AssociateSchedule(Activity_Id entityId, Schedule_Id schedule_id, Hour hour, Duration duration) {
        this.entityId = entityId;
        this.schedule_id = schedule_id;
        this.hour = hour;
        this.duration = duration;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Schedule_Id getSchedule_id() {
        return schedule_id;
    }

    public Hour getHour() {
        return hour;
    }

    public Duration getDuration() {
        return duration;
    }
}
