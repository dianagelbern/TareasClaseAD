package com.tareas.E07;

import com.tareas.E07.model.AddedTo;
import com.tareas.E07.model.Artist;
import com.tareas.E07.model.Playlist;
import com.tareas.E07.model.Song;
import com.tareas.E07.service.AddedToService;
import com.tareas.E07.service.ArtistService;
import com.tareas.E07.service.PlaylistService;
import com.tareas.E07.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final SongService songService;
    private final PlaylistService playlistService;
    private final ArtistService artistService;
    private final AddedToService addedToService;

    @PostConstruct
    public void test(){

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Artist billie = Artist.builder()
                .name("Billie Ailish").build();
        artistService.save(billie);

        Song s = Song.builder()
                .title("You Should See Me in a Crown")
                .album("When We All Fall Asleep, Where Do We Go?")
                .year("2018")
                .build();
        s.addArtist(billie);
        songService.save(s);


        Playlist p = Playlist.builder()
                .name("Música de día de llueve")
                .description("Cuando perfecta para cuando llueve con un chocolate calentito")
                .build();
        playlistService.save(p);

        AddedTo a = AddedTo.builder()
                .dateTime(LocalDateTime.now())
                .orden(1)
                .playlist(p)
                .song(s)
                .build();

        addedToService.save(a);



        System.out.println("Playlist: " + a.getPlaylist().getName() + " Fecha de creación: " +  a.getDateTime().format(formater) + " Orden: " + a.getOrden() + "\n Canciones: " + a.getSong().getTitle() + "\n Artista: " + a.getSong().getArtist().getName());
    }

}
