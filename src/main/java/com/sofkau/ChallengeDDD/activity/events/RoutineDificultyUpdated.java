package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Dificulty;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class RoutineDificultyUpdated extends DomainEvent {
    private final Routine_Id entityId;
    private final Dificulty dificulty;
    public RoutineDificultyUpdated(Routine_Id entityId, Dificulty dificulty) {
        super("sofka.activity.routinedificultyupdated");
        this.entityId=entityId;
        this.dificulty=dificulty;
    }

    public Routine_Id getEntityId() {
        return entityId;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }
}
