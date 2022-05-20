package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.values.Genre;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;

public class ChangePlaylistGenre extends Command {
    private final Classroom_Id entityId;
    private final Playlist_Id playlist_id;
    private final Genre genre;

    public ChangePlaylistGenre(Classroom_Id entityId, Playlist_Id playlist_id, Genre genre) {
        this.entityId = entityId;
        this.playlist_id = playlist_id;
        this.genre = genre;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Playlist_Id getPlaylist_id() {
        return playlist_id;
    }

    public Genre getGenre() {
        return genre;
    }
}
