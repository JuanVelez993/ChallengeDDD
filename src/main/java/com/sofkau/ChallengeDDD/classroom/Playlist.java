package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.ChallengeDDD.classroom.values.*;

import java.util.Objects;

public class Playlist extends Entity<Playlist_Id> {
    private Songs songs;
    private Genre genre;

    public Playlist(Playlist_Id entityId,Songs songs,Genre genre) {
        super(entityId);
        this.songs=songs;
        this.genre=genre;
    }

    public Songs Songs() {
        return songs;
    }

    public Genre Genre() {
        return genre;
    }

    public void updateSongs(Songs songs){
        this.songs= Objects.requireNonNull(songs);

    }

    public void changeGenre(Genre genre){
        this.genre= Objects.requireNonNull(genre);
    }


}
