package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.activity.values.Duration;
import com.sofkau.ChallengeDDD.activity.values.Hour;
import com.sofkau.ChallengeDDD.activity.values.Schedule_Id;


import java.util.Objects;

public class Schedule extends Entity<Schedule_Id> {
    private Hour hour;
    private Duration duration;

    public Schedule(Schedule_Id entityId,Hour hour,Duration duration) {
        super(entityId);
        this.hour=hour;
        this.duration=duration;
    }

    public Hour Hour() {
        return hour;
    }

    public Duration Duration() {
        return duration;
    }

    public void changeHour(Hour hour){
        this.hour= Objects.requireNonNull(hour);
    }

    public void updateDuration(Duration duration){
        this.duration= Objects.requireNonNull(duration);

    }
}
