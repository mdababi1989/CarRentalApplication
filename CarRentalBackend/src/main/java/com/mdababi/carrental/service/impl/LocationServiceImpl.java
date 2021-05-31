package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Location;
import com.mdababi.carrental.repositories.LocationRepository;
import com.mdababi.carrental.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;


    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        locationRepository.deleteById(id);
    }
}
