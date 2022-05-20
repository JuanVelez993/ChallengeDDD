package com.sofkau.ChallengeDDD.classroom.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;

public class Playlist_Id extends Identity {
    public Playlist_Id() {
    }

    private Playlist_Id(String id) {
        super(id);
    }

    public static Playlist_Id of(String id){
        return new Playlist_Id(id);
    }
}
