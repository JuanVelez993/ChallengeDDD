package com.sofkau.ChallengeDDD.activity.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.activity.values.Dificulty;
import com.sofkau.ChallengeDDD.activity.values.Routine_Id;

public class UpdateRoutineDificulty extends Command {
    private final Activity_Id entityId;
    private final Routine_Id routine_id;
    private final Dificulty dificulty;

    public UpdateRoutineDificulty(Activity_Id entityId, Routine_Id routine_id, Dificulty dificulty) {
        this.entityId = entityId;
        this.routine_id = routine_id;
        this.dificulty = dificulty;
    }

    public Activity_Id getEntityId() {
        return entityId;
    }

    public Routine_Id getRoutine_id() {
        return routine_id;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }
}
