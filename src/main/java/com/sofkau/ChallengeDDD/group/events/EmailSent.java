package com.sofkau.ChallengeDDD.group.events;

import co.com.sofka.domain.generic.DomainEvent;

public class EmailSent extends DomainEvent {
    private final String email;
    public EmailSent(String email) {
        super("sofka.group.emailsent");
        this.email=email;
    }

    public String getEmail() {
        return email;
    }
}
