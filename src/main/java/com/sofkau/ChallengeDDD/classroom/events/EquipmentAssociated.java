package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Brand;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_type;

public class EquipmentAssociated extends DomainEvent {
    private final Equipment_Id entityId;
    private final Equipment_type equipment_type;
    private final Brand brand;
    public EquipmentAssociated(Equipment_Id entityId, Equipment_type equipment_type, Brand brand) {
        super("sofka.classroom.equipmentassociated");
        this.entityId=entityId;
        this.equipment_type=equipment_type;
        this.brand=brand;
    }

    public Equipment_Id getEntityId() {
        return entityId;
    }

    public Equipment_type getEquipment_type() {
        return equipment_type;
    }

    public Brand getBrand() {
        return brand;
    }
}
