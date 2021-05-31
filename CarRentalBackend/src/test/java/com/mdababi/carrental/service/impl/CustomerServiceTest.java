package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.exeptionsHandlers.RentalListNotEmptyExeption;
import com.mdababi.carrental.model.Customer;
import com.mdababi.carrental.repositories.CustomerRepository;
import com.mdababi.carrental.repositories.RentalRepository;
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
class CustomerServiceTest {
    @Mock
    CustomerRepository repository;
    @InjectMocks
    CustomerServiceImpl service;
    @Mock
    RentalRepository rentalRepository;

    Customer customer1, customer2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer();
        customer1.setFirstname("Sara");
        customer1.setId(1L);
        customer2 = new Customer();
        customer2.setUsername("username");
        customer2.setId(2L);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(customer1);
        Customer savedcustomer = service.save(customer1);
        assertNotNull(savedcustomer);
        assertEquals("Sara", savedcustomer.getFirstname());
        verify(repository).save(customer1);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(customer1, customer2)));
        List<Customer> categories = service.findAll();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(1).getUsername(), "username");
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(customer1));
        when(repository.findById(2L)).thenReturn(Optional.of(customer2));

        Customer foundcustomer1 = service.findById(1L).orElse(null);
        Customer foundcustomer2 = service.findById(2L).orElse(null);

        assertNotNull(foundcustomer1);
        assertNotNull(foundcustomer2);

        assertEquals(2L, foundcustomer2.getId());
    }

    @Test
    void deleteById() throws RentalListNotEmptyExeption {
        when(repository.findById(1L)).thenReturn(Optional.of(customer1));
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }


}
