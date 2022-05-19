package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Membership;
import com.sofkau.ChallengeDDD.group.values.Name;
import com.sofkau.ChallengeDDD.group.values.Specialty;

import java.util.Objects;

public class Member extends Entity<Member_Id> {
    private  Name name;
    private Membership membership;

    public Member(Member_Id entityId, Name name, Membership membership) {
        super(entityId);
        this.name=name;
        this.membership=membership;
    }

    public Name Name() {
        return name;
    }

    public Membership Membership() {
        return membership;
    }

    public void updateName(Name name){
        this.name= Objects.requireNonNull(name);

    }
    public void changeMembership(Membership membership){
        this.membership=Objects.requireNonNull(membership);
    }
}
