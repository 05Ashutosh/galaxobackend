package com.galaxo.galaxobackend.controller;



import com.galaxo.galaxobackend.model.ExoPlanet;
import com.galaxo.galaxobackend.services.ExoPlanetServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exoplanets")
public class ExoPlanetController {

    private final ExoPlanetServices exoPlanetServices;

    public ExoPlanetController(ExoPlanetServices exoPlanetServices) {
        this.exoPlanetServices = exoPlanetServices;
    }

    // Endpoint to get all exoplanets

    @GetMapping("/all/")
    public ResponseEntity<List<ExoPlanet>> getAllExoPlanets() {
        List<ExoPlanet> exoPlanets = exoPlanetServices.getExoPlanets();
        return ResponseEntity.ok(exoPlanets);
    }

    // Endpoint to create a new exoplanet
    @PostMapping("/create")
    public ResponseEntity<ExoPlanet> createExoPlanet(@RequestBody ExoPlanet exoPlanet) {
        ExoPlanet savedExoPlanet = exoPlanetServices.setExoPlanet(exoPlanet);
        return ResponseEntity.ok(savedExoPlanet);
    }


}
