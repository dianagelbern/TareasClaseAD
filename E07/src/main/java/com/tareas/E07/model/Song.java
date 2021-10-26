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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String album;
    private String year;

    @ManyToOne
    @JoinColumn(name = "artist", foreignKey = @ForeignKey(name = "FK_SONG_ARTIST"))
    private Artist artist;


/*
    //Agregar las FK
    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "song_id"),
    inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists = new ArrayList<>();
*/
    @Builder.Default
    @OneToMany(mappedBy = "song")
    private List<AddedTo> addedTos = new ArrayList<>();


    //Constructores

    public Song(String title, String album, String year) {
        this.title = title;
        album = album;
        this.year = year;
    }

    public Song(String title, String album, String year, Artist artist) {
        this.title = title;
        album = album;
        this.year = year;
        this.artist = artist;
    }

    //Helpers
    /*
    public void addPlaylist(Playlist p){
        playlists.add(p);
        p.getSongs().add(this);
    }

    public void removePlaylist(Playlist p){
        playlists.remove(p);
        p.getSongs().remove(this);
    }

    */
    public void addArtist(Artist a){
        this.artist = a;
        a.getSongs().add(this);
    }

    public void removeArtist(Artist a){
        a.getSongs().remove(this);
        this.artist = null;
    }


}
