package com.sofkau.ChallengeDDD.activity.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotificationSent extends DomainEvent {
    private final String note;
    public NotificationSent(String note) {
        super("sofka.activity.notificationsent");
        this.note=note;
    }

    public String getNote() {
        return note;
    }
}
