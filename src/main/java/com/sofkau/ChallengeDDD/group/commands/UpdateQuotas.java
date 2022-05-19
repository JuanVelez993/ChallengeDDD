package com.sofkau.ChallengeDDD.group.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Quotas;

public class UpdateQuotas extends Command {
    private final Group_Id group_id;
    private final Quotas quotas;

    public UpdateQuotas(Group_Id group_id, Quotas quotas) {
        this.group_id = group_id;
        this.quotas = quotas;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }

    public Quotas getQuotas() {
        return quotas;
    }
}
