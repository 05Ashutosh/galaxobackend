package com.galaxo.galaxobackend.repo;

import com.galaxo.galaxobackend.model.ExoPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExoPlanetRepo extends JpaRepository<ExoPlanet, Long> {
}
