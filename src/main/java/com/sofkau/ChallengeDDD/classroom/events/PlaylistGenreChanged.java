package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Genre;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;

public class PlaylistGenreChanged extends DomainEvent {
    private final Playlist_Id playlist_id;
    private final Genre genre;
    public PlaylistGenreChanged(Playlist_Id playlist_id, Genre genre) {
        super("sofkau.classroom.playlistgenrechanged");
        this.playlist_id=playlist_id;
        this.genre=genre;
    }

    public Playlist_Id getPlaylist_id() {
        return playlist_id;
    }

    public Genre getGenre() {
        return genre;
    }
}
