package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.Identity;

public class Instructor_Id extends Identity {
    public Instructor_Id() {
    }

    private Instructor_Id(String id) {
        super(id);
    }

    public static Instructor_Id of(String id){
        return new Instructor_Id(id);
    }
}
