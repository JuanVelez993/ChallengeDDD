package com.sofkau.ChallengeDDD.classroom;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.activity.values.Activity_Id;
import com.sofkau.ChallengeDDD.classroom.events.*;
import com.sofkau.ChallengeDDD.classroom.values.*;
import com.sofkau.ChallengeDDD.group.Instructor;
import com.sofkau.ChallengeDDD.group.events.InstructorAssociated;
import com.sofkau.ChallengeDDD.group.events.InstructorNameUpdated;
import com.sofkau.ChallengeDDD.group.events.QuotasUpdated;
import com.sofkau.ChallengeDDD.group.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class Classroom extends AggregateEvent<Classroom_Id> {
    protected Capacity capacity;
    protected Set<Playlist> playlists;
    protected Set<Equipment> equipment;
    protected Set<Group_Id> groups;
    protected Set<Activity_Id> activities;

    public Classroom(Classroom_Id entityId, Capacity capacity) {
        super(entityId);
        appendChange(new ClassroomCreated(capacity)).apply();
    }

    private Classroom(Classroom_Id entityId){
        super(entityId);
        subscribe(new ClassroomChange(this));
    }

    public static Classroom from (Classroom_Id classroom_id, List<DomainEvent> events){
        var classroom = new Classroom(classroom_id);
        events.forEach(classroom::applyEvent);
        return classroom;
    }
    //TODO:implement the two aggregates here
    public void associateActivity(Instructor_Id entityId, Name name, Specialty specialty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(specialty);
        appendChange(new InstructorAssociated(entityId,name,specialty)).apply();
    }

    public void associateGroup(Instructor_Id entityId, Name name, Specialty specialty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(specialty);
        appendChange(new InstructorAssociated(entityId,name,specialty)).apply();
    }

    public void associateEquipment(Equipment_Id entityId, Equipment_type equipment_type, Brand brand){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(equipment_type);
        Objects.requireNonNull(brand);
        appendChange(new EquipmentAssociated(entityId,equipment_type,brand)).apply();
    }

    public void associatePlaylist(Playlist_Id entityId,Songs songs,Genre genre){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(songs);
        Objects.requireNonNull(genre);
        appendChange(new PlaylistAssociated(entityId,songs,genre)).apply();
    }

    public void updateCapacity(Classroom_Id entityId, Capacity capacity){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(capacity);
        appendChange(new CapacityUpdated(entityId,capacity)).apply();
    }

    public void changeEquipment_type(Equipment_Id entityId,Equipment_type equipment_type){
        appendChange(new Equipment_TypeChanged(entityId,equipment_type)).apply();

    }

    public void updateEquipmentBrand(Equipment_Id entityId,Brand brand){
        appendChange(new EquipmentBrandUpdated(entityId,brand)).apply();

    }

    public void updatePlaylistSongs(Playlist_Id playlist_id,Songs songs){
        appendChange(new PlaylistSongsUpdated(playlist_id,songs)).apply();

    }
    public void changePlaylistGenre(Playlist_Id playlist_id,Genre genre){
        appendChange(new PlaylistGenreChanged(playlist_id,genre)).apply();

    }

    protected Optional<Equipment> getEquipmentById(Equipment_Id equipment_id){
        return equipment.stream().filter(equipment-> equipment.identity().equals(equipment_id)).findFirst();
    }

    protected Optional<Playlist> getPlaylistById(Playlist_Id playlist_id){
        return playlists.stream().filter(playlist-> playlist.identity().equals(playlist_id)).findFirst();
    }

    public Capacity Capacity() {
        return capacity;
    }

    public Set<Playlist> Playlists() {
        return playlists;
    }

    public Set<Equipment> Equipment() {
        return equipment;
    }
}
