package com.galaxo.galaxobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExoPlanet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageURL;

    // Custom constructor without 'id' since it's auto-generated
    public ExoPlanet(String name, String imageURL, String description) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }
}
