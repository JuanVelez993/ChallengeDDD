package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Membership;
import com.sofkau.ChallengeDDD.group.values.Name;

public class MemberAssociated extends DomainEvent {
    private final Member_Id member_id;
    private final Name name;
    private final Membership membership;
    public MemberAssociated(Member_Id entityId, Name name, Membership membership) {
        super("sofka.group.memberassociated");
        this.member_id=entityId;
        this.name=name;
        this.membership=membership;
    }

    public Member_Id getMember_id() {
        return member_id;
    }

    public Name getName() {
        return name;
    }

    public Membership getMembership() {
        return membership;
    }
}
