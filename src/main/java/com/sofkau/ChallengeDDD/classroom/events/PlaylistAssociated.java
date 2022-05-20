package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Genre;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;
import com.sofkau.ChallengeDDD.classroom.values.Songs;

public class PlaylistAssociated extends DomainEvent {
    private final Playlist_Id entityId;
    private final Songs songs;
    private final Genre genre;

    public PlaylistAssociated(Playlist_Id entityId, Songs songs, Genre genre) {
        super("sofka.classroom.playlistassociated");
        this.entityId=entityId;
        this.songs=songs;
        this.genre=genre;
    }

    public Playlist_Id getEntityId() {
        return entityId;
    }

    public Songs getSongs() {
        return songs;
    }

    public Genre getGenre() {
        return genre;
    }
}
