package com.sofkau.ChallengeDDD.group.commands;

import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Member_Id;
import com.sofkau.ChallengeDDD.group.values.Name;

public class UpdateMemberName {
    private final Group_Id group_id;
    private final Member_Id member_id;
    private final Name name;

    public UpdateMemberName(Group_Id group_id, Member_Id member_id, Name name) {
        this.group_id = group_id;
        this.member_id = member_id;
        this.name = name;
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
}
