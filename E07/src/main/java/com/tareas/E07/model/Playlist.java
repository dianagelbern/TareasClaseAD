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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


/*
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();
*/
    @Builder.Default
    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    private List<AddedTo> addedTos = new ArrayList<>();

    public Playlist(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
