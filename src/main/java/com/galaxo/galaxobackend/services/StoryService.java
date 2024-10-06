//package com.oauth.sampleoauth2.services;
//
//
//import com.oauth.sampleoauth2.model.Story;
//import com.oauth.sampleoauth2.repo.StoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StoryService {
//
//    private final StoryRepository storyRepository;
//
//    @Autowired
//    public StoryService(StoryRepository storyRepository) {
//        this.storyRepository = storyRepository;
//    }
//
//    public Story getOrCreateStory(String title, String storyContent, String planet) {
//        // Check if a story for the given planet already exists
//        Optional<Story> existingStory = storyRepository.findByPlanet(planet);
//
//        if (existingStory.isPresent()) {
//            // If the story exists, return it
//            return existingStory.get();
//        } else {
//            // If not, create a new story, save it, and then return it
//            Story newStory = new Story();
//            newStory.setTitle(title);
//            newStory.setStory(storyContent);
//            newStory.setPlanet(planet);
//            return storyRepository.save(newStory);
//        }
//    }
//
//    public Story getByPlanet(String planet) {
//        // Retrieve a story based on the planet
//        Optional<Story> story = storyRepository.findByPlanet(planet);
//        return story.orElse(null); // Return null if no story is found
//    }
//
//
//    public List<Story> getAllStories() {
//        return storyRepository.findAll();
//    }
//
//    public void setStory(Story story) {
//        storyRepository.save(story);
//    }
//}
//
//



package com.galaxo.galaxobackend.services;


import com.galaxo.galaxobackend.model.Story;
import com.galaxo.galaxobackend.repo.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class StoryService {
    private final StoryRepository storyRepository;
    private final String STORY_DIRECTORY = "stories/";

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
        // Ensure the story directory exists
        new File(STORY_DIRECTORY).mkdirs();
    }

    public Story getOrCreateStory(String title, String storyContent, String planet) {
        Optional<Story> existingStory = storyRepository.findByPlanet(planet);

        if (existingStory.isPresent()) {
            return existingStory.get();
        } else {
            String filePath = saveStoryToFile(planet, storyContent);
            Story newStory = new Story(title, planet, filePath);
            return storyRepository.save(newStory);
        }
    }

    public Story getByPlanet(String planet) {
        return storyRepository.findByPlanet(planet).orElse(null);
    }

    public String getStoryContent(String planet) {
        Story story = getByPlanet(planet);
        if (story != null) {
            return readStoryFromFile(story.getFilePath());
        }
        return null;
    }

    public List<Map<String, Object>> getAllStories() {
        List<Story> stories = storyRepository.findAll();
        List<Map<String, Object>> storiesWithContent = new ArrayList<>();

        for (Story story : stories) {
            Map<String, Object> storyMap = new HashMap<>();
            storyMap.put("id", story.getId());
            storyMap.put("planet", story.getPlanet());
            storyMap.put("title", story.getTitle());
            storyMap.put("filePath", story.getFilePath());
            storyMap.put("content", readStoryFromFile(story.getFilePath()));
            storiesWithContent.add(storyMap);
        }

        return storiesWithContent;
    }


    public String saveStoryToFile(String planet, String storyContent) {
        String fileName = STORY_DIRECTORY + planet + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(storyContent);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readStoryFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setStory(Story story) {
        storyRepository.save(story);
    }
}