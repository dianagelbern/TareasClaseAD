package com.tareas.E07.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Playlist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String Album;
    private String year;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    private List<AddedTo> addedTos = new ArrayList<>();

    public Playlist(String title, String album, String year) {
        this.title = title;
        Album = album;
        this.year = year;
    }


}
