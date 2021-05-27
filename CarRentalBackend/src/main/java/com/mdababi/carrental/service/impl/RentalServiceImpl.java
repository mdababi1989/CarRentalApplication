package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Rental;
import com.mdababi.carrental.repositories.RentalRepository;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl extends BaseServiceImpl<Rental, RentalRepository > {
    public RentalServiceImpl(RentalRepository repository) {
        super(repository);
    }
}
