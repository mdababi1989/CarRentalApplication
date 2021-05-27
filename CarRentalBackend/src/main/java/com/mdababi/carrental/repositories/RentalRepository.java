package com.mdababi.carrental.repositories;

import com.mdababi.carrental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
