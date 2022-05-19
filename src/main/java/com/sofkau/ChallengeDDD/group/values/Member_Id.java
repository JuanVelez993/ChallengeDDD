package com.sofkau.ChallengeDDD.group.values;

import co.com.sofka.domain.generic.Identity;

public class Member_Id extends Identity {
    public Member_Id() {
    }

    private Member_Id(String id) {
        super(id);
    }

    public static Member_Id of(String id){
        return new Member_Id(id);
    }
}
