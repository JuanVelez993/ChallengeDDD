package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.classroom.values.Equipment_Id;

public class Equipment extends Entity<Equipment_Id> {

    public Equipment(Equipment_Id entityId) {
        super(entityId);
    }
}
