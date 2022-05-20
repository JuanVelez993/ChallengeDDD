package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Brand;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;

public class UpdateEquipmentBrand extends Command {
    private final Classroom_Id entityId;
    private final Equipment_Id equipment_id;
    private final Brand brand;

    public UpdateEquipmentBrand(Classroom_Id entityId, Equipment_Id equipment_id, Brand brand) {
        this.entityId = entityId;
        this.equipment_id = equipment_id;
        this.brand = brand;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Equipment_Id getEquipment_id() {
        return equipment_id;
    }

    public Brand getBrand() {
        return brand;
    }
}
