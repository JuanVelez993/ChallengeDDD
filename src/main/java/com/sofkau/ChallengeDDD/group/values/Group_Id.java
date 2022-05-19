package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.Identity;

public class Group_Id extends Identity {
    public Group_Id() {
    }

    private Group_Id(String id) {
        super(id);
    }

    public static Group_Id of(String id){
        return new Group_Id(id);
    }
}
