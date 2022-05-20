package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_type;

public class Equipment_TypeChanged extends DomainEvent {
    private final Equipment_Id equipment_id;
    private final Equipment_type equipment_type;

    public Equipment_TypeChanged(Equipment_Id equipment_id,Equipment_type equipment_type) {
        super("sofka.classroom.equipmenttypechanged");
        this.equipment_id=equipment_id;
        this.equipment_type=equipment_type;
    }

    public Equipment_Id getEquipment_id() {
        return equipment_id;
    }

    public Equipment_type getEquipment_type() {
        return equipment_type;
    }
}
