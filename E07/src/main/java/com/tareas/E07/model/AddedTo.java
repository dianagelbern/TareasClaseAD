package com.tareas.E07.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class AddedTo {

    @EmbeddedId
    private AddedToPK id = new AddedToPK();

    @ManyToOne
    @JoinColumn(name = "song") //Falta mapsId con los ide de AddedToPK
    private Song song;

    @ManyToOne
    @JoinColumn(name = "playlist") //Falta mapsId
    private Playlist playlist;

    private DateTimeFormat datetime;
    private int order;

    public AddedTo(DateTimeFormat datetime, int order) {
        this.datetime = datetime;
        this.order = order;
    }

    public AddedTo(Song song, Playlist playlist, DateTimeFormat datetime, int order) {
        this.song = song;
        this.playlist = playlist;
        this.datetime = datetime;
        this.order = order;
    }

    public AddedTo(Song song, Playlist playlist) {
        this.song = song;
        this.playlist = playlist;
    }
}
