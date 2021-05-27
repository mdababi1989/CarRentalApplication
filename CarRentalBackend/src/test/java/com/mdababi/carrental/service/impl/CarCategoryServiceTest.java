package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.CarCategory;
import com.mdababi.carrental.repositories.CarCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarCategoryServiceTest {
    @Mock
    CarCategoryRepository repository;
    @InjectMocks
    CarCategoryServiceImpl service;

    CarCategory category1, category2;

    @BeforeEach
    void setUp() {
        category1 = new CarCategory("Audi", new ArrayList<>());
        category1.setId(1L);
        category2 = new CarCategory("Mercedes", new ArrayList<>());
        category2.setId(2L);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(category1);
        CarCategory savedCategory = service.save(category1);
        assertNotNull(savedCategory);
        assertEquals("Audi", savedCategory.getCategoryName());
        verify(repository).save(category1);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(category1, category2)));
        List<CarCategory> categories = service.findAll();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(1).getCategoryName(), "Mercedes");
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(category1));
        when(repository.findById(2L)).thenReturn(Optional.of(category2));

        CarCategory foundCategory1 = service.findById(1L).orElse(null);
        CarCategory foundCategory2 = service.findById(2L).orElse(null);

        assertNotNull(foundCategory1);
        assertNotNull(foundCategory2);

        assertEquals(2L, foundCategory2.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void delete() {
        service.delete(category1);
        service.delete(category2);
        verify(repository, times(2)).delete(any());
    }

}
