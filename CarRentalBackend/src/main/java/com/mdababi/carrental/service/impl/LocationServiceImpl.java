package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Location;
import com.mdababi.carrental.repositories.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends BaseServiceImpl<Location, LocationRepository > {

    public LocationServiceImpl(LocationRepository repository) {
        super(repository);
    }
}
