package com.sofkau.ChallengeDDD.activity.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Duration;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;

public class UpdateScheduleDuration extends Command {
    private final Activity_Id entityId;
    private final Schedule_Id schedule_id;
    private final Duration duration;

    public UpdateScheduleDuration(Activity_Id entityId, Schedule_Id schedule_id, Duration duration) {
        this.entityId = entityId;
        this.schedule_id = schedule_id;
        this.duration = duration;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Schedule_Id getSchedule_id() {
        return schedule_id;
    }

    public Duration getDuration() {
        return duration;
    }
}
