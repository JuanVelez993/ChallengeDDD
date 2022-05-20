package com.sofkau.ChallengeDDD.classroom.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.ChallengeDDD.classroom.values.Classroom_Id;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;
import com.sofkau.ChallengeDDD.classroom.values.Songs;

public class UpdatePlaylistSongs extends Command {
    private final Classroom_Id entityId;
    private final Playlist_Id playlist_id;
    private final Songs songs;

    public UpdatePlaylistSongs(Classroom_Id entityId, Playlist_Id playlist_id, Songs songs) {
        this.entityId = entityId;
        this.playlist_id = playlist_id;
        this.songs = songs;
    }

    public Classroom_Id getEntityId() {
        return entityId;
    }

    public Playlist_Id getPlaylist_id() {
        return playlist_id;
    }

    public Songs getSongs() {
        return songs;
    }
}
