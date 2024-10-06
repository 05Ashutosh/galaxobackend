package com.galaxo.galaxobackend.services;



import com.galaxo.galaxobackend.model.ExoPlanet;
import com.galaxo.galaxobackend.repo.ExoPlanetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExoPlanetServices {

    private final ExoPlanetRepo exoPlanetRepo;

    public ExoPlanetServices(ExoPlanetRepo exoPlanetRepo) {
        this.exoPlanetRepo = exoPlanetRepo;
    }

    public List<ExoPlanet> getExoPlanets() {
        return exoPlanetRepo.findAll();
    }

    public ExoPlanet setExoPlanet(ExoPlanet exoPlanet) {
        return exoPlanetRepo.save(exoPlanet);
    }
}
