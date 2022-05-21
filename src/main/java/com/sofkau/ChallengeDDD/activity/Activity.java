package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.events.*;
import com.sofkau.ChallengeDDD.activity.values.*;



import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Activity extends AggregateEvent<Activity_Id> {
    protected Activity_Name activity_name;
    protected Set<Schedule> schedules;
    protected Set<Routine> routines;

    public Activity(Activity_Id entityId,Activity_Name activity_name) {
        super(entityId);
        appendChange(new ActivityCreated(activity_name)).apply();
    }

    private Activity(Activity_Id entityId){
        super(entityId);
        subscribe(new ActivityChange(this));
    }

    public static Activity from (Activity_Id activity_id, List<DomainEvent> events){
        var activity = new Activity(activity_id);
        events.forEach(activity::applyEvent);
        return activity;
    }

    public void changeActivity_Name(Activity_Id entityId, Activity_Name activity_name){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(activity_name);
        appendChange(new Activity_NameChanged(entityId,activity_name)).apply();
    }

    public void associateRoutine(Routine_Id entityId, Exercises exercises, Dificulty dificulty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(exercises);
        Objects.requireNonNull(dificulty);
        appendChange(new RoutineAssociated(entityId,exercises,dificulty)).apply();
    }

    public void updateRoutineExercises(Routine_Id entityId, Exercises exercises){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(exercises);
        appendChange(new RoutineExercisesUpdated(entityId,exercises)).apply();
    }

    public void updateRoutineDificulty(Routine_Id entityId, Dificulty dificulty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(dificulty);
        appendChange(new RoutineDificultyUpdated(entityId,dificulty)).apply();
    }

    public void associateSchedule(Schedule_Id entityId,Hour hour,Duration duration){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(hour);
        Objects.requireNonNull(duration);
        appendChange(new ScheduleAssociated(entityId,hour,duration)).apply();
    }

    public void changeScheduleHour(Schedule_Id entityId,Hour hour){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(hour);
        appendChange(new ScheduleHourChanged(entityId,hour)).apply();
    }

    public void updateScheduleDuration(Schedule_Id entityId,Duration duration){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(duration);
        appendChange(new ScheduleDurationUpdated(entityId,duration)).apply();
    }

    protected Optional<Schedule> getScheduleById(Schedule_Id schedule_id){
        return schedules.stream().filter(schedule-> schedule.identity().equals(schedule_id)).findFirst();
    }

    protected Optional<Routine> getRoutineById(Routine_Id routine_id){
        return routines.stream().filter(routine-> routine.identity().equals(routine_id)).findFirst();
    }

    public Activity_Name Activity_name() {
        return activity_name;
    }

    public Set<Schedule> Schedules() {
        return schedules;
    }

    public Set<Routine> Routines() {
        return routines;
    }

    public void notifyManagment(String note) {
        Objects.requireNonNull(note);
        appendChange(new NotificationSent(note)).apply();
    }
}
