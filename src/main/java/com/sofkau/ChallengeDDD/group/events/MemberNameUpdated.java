package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Name;

public class MemberNameUpdated extends DomainEvent {
    private final Member_Id member_id;
    private final Name name;
    public MemberNameUpdated(Member_Id entityId, Name name) {
        super("sofka.group.membernameupdated");
        this.member_id=entityId;
        this.name=name;
    }

    public Member_Id getMember_id() {
        return member_id;
    }

    public Name getName() {
        return name;
    }
}
