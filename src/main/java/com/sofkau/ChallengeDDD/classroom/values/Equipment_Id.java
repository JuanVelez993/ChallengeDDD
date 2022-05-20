package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.Identity;


public class Equipment_Id extends Identity {
    public Equipment_Id() {
    }

    private Equipment_Id(String id) {
        super(id);
    }

    public static Equipment_Id of(String id){
        return new Equipment_Id(id);
    }
}
