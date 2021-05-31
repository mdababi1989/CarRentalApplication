package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Location;
import com.mdababi.carrental.repositories.LocationRepository;
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
class LocationServiceTest {
    @Mock
    LocationRepository repository;
    @InjectMocks
    LocationServiceImpl service;

    Location location1, location2;

    @BeforeEach
    void setUp() {
        location1 = new Location("Tunis");
        location1.setId(1L);
        location2 = new Location("Bizerte");
        location2.setId(2L);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(location1);
        Location savedlocation = service.save(location1);
        assertNotNull(savedlocation);
        assertEquals("Tunis", savedlocation.getCity());
        verify(repository).save(location1);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(location1, location2)));
        List<Location> categories = service.findAll();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(1).getId(), 2L);
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(location1));
        when(repository.findById(2L)).thenReturn(Optional.of(location2));

        Location foundlocation1 = service.findById(1L).orElse(null);
        Location foundlocation2 = service.findById(2L).orElse(null);

        assertNotNull(foundlocation1);
        assertNotNull(foundlocation2);

        assertEquals(2L, foundlocation2.getId());
    }

    @Test
    void deleteById() throws Exception {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }


}
