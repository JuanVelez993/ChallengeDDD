package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.Identity;


public class Classroom_Id extends Identity {
    public Classroom_Id() {
    }

    private Classroom_Id(String id) {
        super(id);
    }

    public static Classroom_Id of(String id){
        return new Classroom_Id(id);
    }
}
