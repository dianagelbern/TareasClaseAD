package com.tareas.E07.service;

import com.tareas.E07.model.Artist;
import com.tareas.E07.repository.ArtistRepository;
import com.tareas.E07.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist, Long, ArtistRepository> {
    public ArtistService(ArtistRepository repo) {
        super(repo);
    }
}
