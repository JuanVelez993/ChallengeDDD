package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.classroom.values.Brand;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_type;
import com.sofkau.ChallengeDDD.group.values.Name;
import com.sofkau.ChallengeDDD.group.values.Specialty;

import java.util.Objects;

public class Equipment extends Entity<Equipment_Id> {
    private Equipment_type equipment_type;
    private Brand brand;

    public Equipment(Equipment_Id entityId,Equipment_type equipment_type,Brand brand) {
        super(entityId);
        this.equipment_type=equipment_type;
        this.brand=brand;
    }

    public Equipment_type Equipment_type() {
        return equipment_type;
    }

    public Brand Brand() {
        return brand;
    }

    public void changeEquipment_type(Equipment_type equipment_type){
        this.equipment_type=Objects.requireNonNull(equipment_type);
    }

    public void updateBrand(Brand brand){
        this.brand= Objects.requireNonNull(brand);

    }
}
