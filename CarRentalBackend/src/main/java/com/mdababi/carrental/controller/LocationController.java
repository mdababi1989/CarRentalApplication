package com.mdababi.carrental.controller;

import com.mdababi.carrental.model.Location;
import com.mdababi.carrental.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {
    LocationService locationService;

    @PostMapping("/add")
    public ResponseEntity<Location> saveLocation(@Valid @RequestBody Location location) {
        Location savedLocation = locationService.save(location);
        return new ResponseEntity(savedLocation, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        Location location = locationService.findById(id).orElse(null);
        if (location == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Location> updateLocation(@Valid @RequestBody Location location) {
        Location savedLocation = locationService.save(location);
        return new ResponseEntity(savedLocation, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocationById(@PathVariable("id") Long id) {
        locationService.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@RequestBody Location location) {
        if (location != null)
            if (location.getId() > 0)
                locationService.delete(location);
    }


}
