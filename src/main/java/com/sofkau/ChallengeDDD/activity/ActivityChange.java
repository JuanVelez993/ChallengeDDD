package com.sofkau.ChallengeDDD.activity;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.ChallengeDDD.activity.events.*;



import java.util.HashSet;

public class ActivityChange extends EventChange {
    public ActivityChange(Activity activity) {
        apply((ActivityCreated event)->{
            activity.activity_name= event.getActivity_name();
            activity.schedules=new HashSet<>();
            activity.routines=new HashSet<>();
        });

        apply((Activity_NameChanged event)->{
            activity.activity_name= event.getActivity_name();

        });

        apply((ScheduleAssociated event)->{
            if(activity.schedules.size()>2){
                throw new IllegalArgumentException("An Activity cannot have more than 2 schedules");
            }
            activity.schedules.add(new Schedule(event.getEntityId(), event.getHour(), event.getDuration()));

        });

        apply((ScheduleHourChanged event)->{
            var schedule=activity.getScheduleById(event.getEntityId()).orElseThrow(()-> new IllegalArgumentException("Schedule not found"));
            schedule.changeHour(event.getHour());


        });

        apply((ScheduleDurationUpdated event)->{
            var schedule=activity.getScheduleById(event.getEntityId()).orElseThrow(()-> new IllegalArgumentException("Schedule not found"));
            schedule.updateDuration(event.getDuration());

        });

        apply((RoutineAssociated event)->{
            if(activity.routines.size()>2){
                throw new IllegalArgumentException("An Activity cannot have more than 2 routines");
            }
            activity.routines.add(new Routine(event.getEntityId(), event.getExercises(), event.getDificulty()));

        });

        apply((RoutineDificultyUpdated event)->{
            var routine=activity.getRoutineById(event.getEntityId()).orElseThrow(()-> new IllegalArgumentException("Routine not found"));
            routine.updateDificulty(event.getDificulty());

        });

        apply((RoutineExercisesUpdated event)->{
            var routine=activity.getRoutineById(event.getEntityId()).orElseThrow(()-> new IllegalArgumentException("Routine not found"));
            routine.updateExercises(event.getExercises());

        });
    }
}
