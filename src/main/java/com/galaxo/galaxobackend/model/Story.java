//package com.oauth.sampleoauth2.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Story {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String planet;
//    private String title;
//    @Column(length = 4000)
//    private String story;
//
//    public Story(String title, String story, String planet) {
//    }
//}


package com.galaxo.galaxobackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planet;
    private String title;
    private String filePath;

    public Story(String title, String planet, String filePath) {
        this.title = title;
        this.planet = planet;
        this.filePath = filePath;
    }
}