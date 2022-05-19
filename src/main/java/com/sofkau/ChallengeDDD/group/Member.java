package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.group.values.Member_Id;

public class Member extends Entity<Member_Id> {

    public Member(Member_Id entityId) {
        super(entityId);
    }
}
