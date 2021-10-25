package com.tareas.E07.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Song implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "artist")
    private Artist artist;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "playlist_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "song", fetch = FetchType.EAGER)
    private List<AddedTo> addedTos = new ArrayList<>();

    public Song(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Song(String name, String description, Artist artist) {
        this.name = name;
        this.description = description;
        this.artist = artist;
    }

    //Helpers
    public void addPlaylist(Playlist p){
        playlists.add(p);
        p.getSongs().add(this);
    }

    public void removePlaylist(Playlist p){
        playlists.remove(p);
        p.getSongs().remove(this);
    }
}
