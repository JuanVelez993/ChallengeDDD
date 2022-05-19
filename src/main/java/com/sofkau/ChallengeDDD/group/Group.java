package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.ChallengeDDD.group.values.Group_Id;

public class Group extends AggregateEvent<Group_Id> {

    public Group(Group_Id entityId) {
        super(entityId);
    }
}
