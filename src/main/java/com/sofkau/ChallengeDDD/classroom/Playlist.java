package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;

public class Playlist extends Entity<Playlist_Id> {

    public Playlist(Playlist_Id entityId) {
        super(entityId);
    }
}
