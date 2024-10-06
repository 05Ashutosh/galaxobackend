package com.galaxo.galaxobackend.repo;

import com.galaxo.galaxobackend.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    Optional<Story> findByPlanet(String planet);
}
