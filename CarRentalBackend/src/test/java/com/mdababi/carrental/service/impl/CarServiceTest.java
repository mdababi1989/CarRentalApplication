package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Car;
import com.mdababi.carrental.model.enums.CarType;
import com.mdababi.carrental.repositories.CarRepository;
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
class CarServiceTest {
    @Mock
    CarRepository repository;
    @InjectMocks
    CarServiceImpl service;

    Car car1, car2;

    @BeforeEach
    void setUp() {
        car1 = new Car();
        car1.setCarType(CarType.Small);
        car1.setId(1L);
        car2 = new Car();
        car2.setCapacity(5);
        car2.setId(2L);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(car1);
        Car savedCar = service.save(car1);
        assertNotNull(savedCar);
        assertEquals(CarType.Small, savedCar.getCarType());
        verify(repository).save(car1);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(car1, car2)));
        List<Car> categories = service.findAll();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(1).getCapacity(), 5);
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(car1));
        when(repository.findById(2L)).thenReturn(Optional.of(car2));

        Car foundcar1 = service.findById(1L).orElse(null);
        Car foundcar2 = service.findById(2L).orElse(null);

        assertNotNull(foundcar1);

        assertNotNull(foundcar2);

        assertEquals(2L, foundcar2.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void delete() {
        service.delete(car1);
        service.delete(car2);
        verify(repository, times(2)).delete(any());
    }

}
