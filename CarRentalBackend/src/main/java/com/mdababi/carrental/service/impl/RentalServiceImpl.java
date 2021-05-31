package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Rental;
import com.mdababi.carrental.repositories.RentalRepository;
import com.mdababi.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;

    @Override
    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        rentalRepository.deleteById(id);
    }
}
