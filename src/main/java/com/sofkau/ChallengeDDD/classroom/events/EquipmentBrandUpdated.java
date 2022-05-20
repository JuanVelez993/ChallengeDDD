package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Brand;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;

public class EquipmentBrandUpdated extends DomainEvent {
    private final Equipment_Id entityId;
    private final Brand brand;
    public EquipmentBrandUpdated(Equipment_Id entityId, Brand brand) {
        super("sofka.classroom.equipmentbrandupdated");
        this.entityId=entityId;
        this.brand=brand;
    }

    public Equipment_Id getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
