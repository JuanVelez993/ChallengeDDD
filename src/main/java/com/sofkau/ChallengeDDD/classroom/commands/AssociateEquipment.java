package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Brand;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_type;

public class AssociateEquipment extends Command {
    private final Classroom_Id entityId;
    private final Equipment_Id equipment_id;
    private final Equipment_type equipment_type;
    private final Brand brand;

    public AssociateEquipment(Classroom_Id entityId, Equipment_Id equipment_id, Equipment_type equipment_type, Brand brand) {
        this.entityId = entityId;
        this.equipment_id = equipment_id;
        this.equipment_type = equipment_type;
        this.brand = brand;
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

    public Brand getBrand() {
        return brand;
    }
}
