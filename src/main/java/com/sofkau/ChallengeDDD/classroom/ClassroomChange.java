package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.ChallengeDDD.activity.events.Activity_NameChanged;
import com.sofkau.ChallengeDDD.classroom.events.*;



import java.util.HashSet;

public class ClassroomChange extends EventChange {
    public ClassroomChange(Classroom classroom) {

        apply((ClassroomCreated event)->{
            classroom.capacity= event.getCapacity();
            classroom.equipment=new HashSet<>();
            classroom.playlists=new HashSet<>();
        });

        apply((CapacityUpdated event)->{
            classroom.capacity= event.getCapacity();

        });

        apply((ActivityAssociated event)->{
           classroom.activities= event.getActivity_id();

        });

        apply((GroupAssociated event)->{
            classroom.groups= event.getGroup_id();

        });

        apply((EquipmentAssociated event)->{
            if(classroom.equipment.size()>30){
                throw new IllegalArgumentException("We don't need more than 30 equipments per classroom");
            }
            classroom.equipment.add(new Equipment(event.getEntityId(), event.getEquipment_type(), event.getBrand()));

        });

        apply((Equipment_TypeChanged event)->{
            var equipment=classroom.getEquipmentById(event.getEquipment_id()).orElseThrow(()-> new IllegalArgumentException("Equipment not found"));
            equipment.changeEquipment_type(event.getEquipment_type());

        });

        apply((EquipmentBrandUpdated event)->{
            var equipment=classroom.getEquipmentById(event.getEntityId()).orElseThrow(()-> new IllegalArgumentException("Equipment not found"));
            equipment.updateBrand(event.getBrand());

        });

        apply((PlaylistAssociated event)->{
            if(classroom.playlists.size()>2){
                throw new IllegalArgumentException("We don't need more than 2 playlist per classroom");
            }
            classroom.playlists.add(new Playlist(event.getEntityId(), event.getSongs(), event.getGenre()));

        });

        apply((PlaylistSongsUpdated event)->{
            var playlist=classroom.getPlaylistById(event.getPlaylist_id()).orElseThrow(()-> new IllegalArgumentException("Playlist not found"));
            playlist.updateSongs(event.getSongs());

        });

        apply((PlaylistGenreChanged event)->{
            var playlist=classroom.getPlaylistById(event.getPlaylist_id()).orElseThrow(()-> new IllegalArgumentException("Playlist not found"));
            playlist.changeGenre(event.getGenre());

        });


    }
}
