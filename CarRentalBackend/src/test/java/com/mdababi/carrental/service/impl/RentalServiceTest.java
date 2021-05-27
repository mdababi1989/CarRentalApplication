package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Rental;
import com.mdababi.carrental.repositories.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest {
    @Mock
    RentalRepository repository;
    @InjectMocks
    RentalServiceImpl service;

    Rental rental1, rental2;


    @BeforeEach
    void setUp() {
        LocalDate pickupDate = LocalDate.of(2021, 12, 15);
        rental1 = new Rental();
        rental1.setPickupDate(pickupDate);
        rental1.setId(1L);
        rental2 = new Rental();
        rental2.setId(2L);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(rental1);
        Rental savedrental = service.save(rental1);
        assertNotNull(savedrental);
        assertEquals(2021, savedrental.getPickupDate().getYear());
        verify(repository).save(rental1);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(rental1, rental2)));
        List<Rental> categories = service.findAll();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(1).getId(), 2L);
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(rental1));
        when(repository.findById(2L)).thenReturn(Optional.of(rental2));

        Rental foundrental1 = service.findById(1L).orElse(null);
        Rental foundrental2 = service.findById(2L).orElse(null);

        assertNotNull(foundrental1);
        assertNotNull(foundrental2);

        assertEquals(2L, foundrental2.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void delete() {
        service.delete(rental1);
        service.delete(rental2);
        verify(repository, times(2)).delete(any());
    }

}
