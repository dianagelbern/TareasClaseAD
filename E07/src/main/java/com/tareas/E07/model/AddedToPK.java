package com.tareas.E07.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter @Setter
@Builder
public class AddedToPK implements Serializable {

    long song_id;
    long playlist_id;

}
