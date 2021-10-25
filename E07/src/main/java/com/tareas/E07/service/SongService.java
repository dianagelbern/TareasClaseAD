package com.tareas.E07.service;

import com.tareas.E07.model.Song;
import com.tareas.E07.repository.SongRepository;
import com.tareas.E07.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song, Long, SongRepository> {
    public SongService(SongRepository repo) {
        super(repo);
    }
}
