package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Membership;

public class MemberMemebershipChanged extends DomainEvent {
    private final Member_Id member_id;
    private final Membership membership;

    public MemberMemebershipChanged(Member_Id entityId, Membership membership) {
        super("sofka.group.membermembershipchanged");
        this.member_id=entityId;
        this.membership=membership;
    }

    public Member_Id getMember_id() {
        return member_id;
    }

    public Membership getMembership() {
        return membership;
    }
}
