package com.mdababi.carrental.service;

import com.mdababi.carrental.exeptionsHandlers.CarCategoryNotEmptyExeption;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    T save(T t);
    List<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id) throws Exception;
}
