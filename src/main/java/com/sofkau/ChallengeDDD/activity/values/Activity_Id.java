package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.Identity;


public class Activity_Id extends Identity {
    public Activity_Id() {
    }

    private Activity_Id(String id) {
        super(id);
    }

    public static Activity_Id of(String id){
        return new Activity_Id(id);
    }
}
