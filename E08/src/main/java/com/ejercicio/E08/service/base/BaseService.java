package com.ejercicio.E08.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService <T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID>{

    @Autowired
    protected R repository;

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T edit(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deteleById(ID id) {
        repository.deleteById(id);
    }
}
