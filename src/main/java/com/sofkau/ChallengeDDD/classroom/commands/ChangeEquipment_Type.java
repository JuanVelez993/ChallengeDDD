package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_type;

public class ChangeEquipment_Type extends Command {
    private final Classroom_Id entityId;
    private final Equipment_Id equipment_id;
    private final Equipment_type equipment_type;

    public ChangeEquipment_Type(Classroom_Id entityId, Equipment_Id equipment_id, Equipment_type equipment_type) {
        this.entityId = entityId;
        this.equipment_id = equipment_id;
        this.equipment_type = equipment_type;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Equipment_Id getEquipment_id() {
        return equipment_id;
    }

    public Equipment_type getEquipment_type() {
        return equipment_type;
    }
}
