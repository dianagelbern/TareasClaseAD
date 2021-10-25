package com.tareas.E07.service;

import com.tareas.E07.model.Playlist;
import com.tareas.E07.repository.PlaylistRepository;
import com.tareas.E07.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseService<Playlist, Long, PlaylistRepository> {
    public PlaylistService(PlaylistRepository repo) {
        super(repo);
    }
}
