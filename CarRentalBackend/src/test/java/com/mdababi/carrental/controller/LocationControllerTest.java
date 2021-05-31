package com.mdababi.carrental.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdababi.carrental.model.Location;
import com.mdababi.carrental.service.LocationService;
import com.mdababi.carrental.service.impl.LocationServiceImpl;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.JUnitException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = LocationController.class)
class LocationControllerTest {
    @MockBean
    LocationService service;
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;

    private Location location1, location2, locationNonValid;

    @BeforeEach
    void setUp() {
        location1 = new Location("Tunis");
        location1.setId(1L);
        location2 = new Location("Sousse");
        location2.setId(2L);
        locationNonValid = new Location("");
    }

    @Test
    void saveLocationOk() throws Exception {
        mvc.perform(post("/location/add").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(location1))).andExpect(status().isCreated());
    }

    @Test
    void saveLocationNonValid() throws Exception {
        mvc.perform(post("/location/add").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(locationNonValid))).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.city", is("City name is mandatory")));

    }

    @Test
    void getLocationById() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.of(location1));
        mvc.perform(get("/location/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.city", is("Tunis")));

        mvc.perform(get("/location/3")).andExpect(status().isNotFound());
    }

    @Test
    void deleteLocationById() throws Exception {
        mvc.perform(delete("/location/1"));
        mvc.perform(delete("/location/3"));
        verify(service).deleteById(1L);
        verify(service, times(2)).deleteById(any());
    }


}