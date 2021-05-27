package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BaseServiceImpl<T, Repository extends JpaRepository<T, Long>> implements BaseService<T> {

    private final Repository repository;

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }
}
