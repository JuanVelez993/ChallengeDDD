package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Quotas;

public class GroupCreated extends DomainEvent {
    private final Quotas quotas;
    public GroupCreated(Quotas quotas) {
        super("sofka.group.groupcreated");
        this.quotas=quotas;
    }

    public Quotas getQuotas() {
        return quotas;
    }
}
