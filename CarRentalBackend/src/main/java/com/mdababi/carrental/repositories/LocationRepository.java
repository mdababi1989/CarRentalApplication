package com.mdababi.carrental.repositories;

import com.mdababi.carrental.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
