package com.sofkau.ChallengeDDD.activity.values;

import co.com.sofka.domain.generic.Identity;


public class Routine_Id extends Identity {
    public Routine_Id() {
    }

    private Routine_Id(String id) {
        super(id);
    }

    public static Routine_Id of(String id){
        return new Routine_Id(id);
    }
}
