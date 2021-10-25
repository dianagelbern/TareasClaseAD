package com.tareas.E07.service;

import com.tareas.E07.model.AddedTo;
import com.tareas.E07.model.AddedToPK;
import com.tareas.E07.repository.AddedToRepository;
import com.tareas.E07.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddedToService extends BaseService<AddedTo, AddedToPK, AddedToRepository> {



    public AddedToService(AddedToRepository repo) {
        super(repo);
    }
}
