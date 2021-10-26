package com.tareas.E07.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AddedTo {

    @Builder.Default
    @EmbeddedId
    private AddedToPK id = new AddedToPK();

    @CreatedDate
    private LocalDateTime dateTime;
    private int orden;


    public AddedTo(LocalDateTime dateTime, int orden) {
        this.dateTime = dateTime;
        this.orden = orden;
    }

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    //Helpers
    public void addToSong(Song s){
        song = s;
        s.getAddedTos().add(this);
    }

    public void removeFromSong(Song s){
        s.getAddedTos().remove(this);
        song = null;
    }

    public void addToPlaylist(Playlist p){
        playlist = p;
        p.getAddedTos().add(this);
    }

    public void removeFromPlaylist(Playlist p){
        p.getAddedTos().remove(this);
        playlist = null;
    }

    public void addSongPlaylist(Song s, Playlist p){
        addToSong(s);
        addToPlaylist(p);
    }

    public void removeSongPlaylist(Song s, Playlist p){
        removeFromSong(s);
        removeFromPlaylist(p);
    }
}
