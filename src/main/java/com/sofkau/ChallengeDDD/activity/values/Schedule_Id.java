package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.Identity;


public class Schedule_Id extends Identity {
    public Schedule_Id() {
    }

    private Schedule_Id(String id) {
        super(id);
    }

    public static Schedule_Id of(String id){
        return new Schedule_Id(id);
    }
}
