package com.sofkau.ChallengeDDD.classroom.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.classroom.values.Playlist_Id;
import com.sofkau.ChallengeDDD.classroom.values.Songs;

public class PlaylistSongsUpdated extends DomainEvent {
    private final Playlist_Id playlist_id;
    private final Songs songs;
    public PlaylistSongsUpdated(Playlist_Id playlist_id, Songs songs) {
        super("sofka.classroom.playlistsongupdated");
        this.playlist_id=playlist_id;
        this.songs=songs;
    }

    public Playlist_Id getPlaylist_id() {
        return playlist_id;
    }

    public Songs getSongs() {
        return songs;
    }
}
