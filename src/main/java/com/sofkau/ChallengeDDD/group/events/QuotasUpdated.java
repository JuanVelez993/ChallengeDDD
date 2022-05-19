package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.values.Group_Id;
import com.sofkau.ChallengeDDD.group.values.Quotas;

public class QuotasUpdated extends DomainEvent {
    private final Group_Id group_id;
    private final Quotas quotas;
    public QuotasUpdated(Group_Id entityId, Quotas quotas) {
        super("sofka.group.quotasupdated");
        this.group_id=entityId;
        this.quotas=quotas;
    }

    public Group_Id getGroup_id() {
        return group_id;
    }

    public Quotas getQuotas() {
        return quotas;
    }
}
