package com.sofkau.ChallengeDDD.group.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Membership;
import com.sofkau.ChallengeDDD.group.values.Name;

public class AssociateMember extends Command {
    private final Group_Id group_id;
    private final Member_Id member_id;
    private final Name name;
    private final Membership membership;

    public AssociateMember(Group_Id group_id, Member_Id entityId, Name name, Membership membership){
        this.group_id = group_id;
        this.member_id=entityId;
        this.name=name;
        this.membership=membership;
    }

    public Group_Id getGroup_id() {
        return group_id;
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
