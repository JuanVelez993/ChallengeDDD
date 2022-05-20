package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Group_Id;

public class GroupAssociated extends DomainEvent {
    private final Group_Id group_id;
    public GroupAssociated(Group_Id group_id) {
        super("sofka.classroom.groupassociated");
        this.group_id=group_id;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }
}
