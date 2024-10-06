//package com.oauth.sampleoauth2.controller;
//
//import com.oauth.sampleoauth2.model.Story;
//import com.oauth.sampleoauth2.services.StoryService;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class UserController {
//
//
//
//    @Autowired
//    private StoryService storyService;
//
//    private final ChatClient chatClient;
//
////    private final UserService userService;
//    public UserController( ChatClient.Builder chatClientBuilder) {
////        this.userService = userService;
//        this.chatClient = chatClientBuilder.build();
//    }
//
//    @GetMapping("/user-info")
//    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User principal) {
//        System.out.println(principal.getAttributes());
//        return principal.getAttributes();
//    }
//
//    @GetMapping("make/story")
//    public ResponseEntity<Story> story(@RequestParam String planet) {
//        Story existingStory = storyService.getByPlanet(planet);
//        if (existingStory != null) {
//            // Return the existing story if found
//            System.out.println(existingStory);
//            return ResponseEntity.ok(existingStory);
//        }
//        // Query for the story using the ChatClient
//        String prompt = "generate a (500 words) medium story about mars include the facts we know about the exo planet " + planet + " for the age of the child small  think you are a story writer keep intact the facts ";
//        String storyContent = chatClient.prompt()
//                .user(prompt)
//                .call()
//                .content();
//
//        String title = chatClient.prompt()
//                .user("give me a title for this story ----" + storyContent)
//                .call()
//                .content();
//
//        // Use the StoryService to either get or create the story
//        Story story = storyService.getOrCreateStory(title, storyContent, planet);
//
//        // Return the story as the response
//        return ResponseEntity.ok(story);
//    }
//
//    @GetMapping("/list/allstories")
//    public ResponseEntity<List<Story>> allStories() {
//        List<Story> stories = storyService.getAllStories();
//        return ResponseEntity.ok(stories);
//    }
//
//}


package com.galaxo.galaxobackend.controller;


import com.galaxo.galaxobackend.model.Story;
import com.galaxo.galaxobackend.services.StoryService;
import lombok.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private StoryService storyService;
    private final ChatClient chatClient;




    public UserController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/user-info")
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal.getAttributes());
        return principal.getAttributes();
    }

    @GetMapping("make/story")
    public ResponseEntity<Map<String, Object>> story(@RequestParam String planet) {
        Story existingStory = storyService.getByPlanet(planet);
        String storyContent;

        if (existingStory != null) {
            storyContent = storyService.getStoryContent(planet);
        } else {
            String prompt = "generate a  short story about "+ planet +" include the facts we know about the exoplanet  for the age of the child small think you are a story writer keep intact the facts";
            storyContent = chatClient.prompt().user(prompt).call().content();
            String title = chatClient.prompt().user("give me a title for this story ----" + storyContent).call().content();
            existingStory = storyService.getOrCreateStory(title, storyContent, planet);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("title", existingStory.getTitle());
        response.put("planet", existingStory.getPlanet());
        response.put("story", storyContent);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list/allstories")
    public ResponseEntity<List<Map<String, Object>>> allStories() {
        List<Map<String, Object>> stories = storyService.getAllStories();
        return ResponseEntity.ok(stories);
    }

    @GetMapping("/audio")
    public ResponseEntity<?> getAudio(@RequestParam String planet) {
//        Story existingStory = storyService.getByPlanet(planet);
//        if (existingStory == null) {
//            return ResponseEntity.notFound().build();
//        }

//        String storyContent = storyService.getStoryContent(planet);
        String storyContent = "Hi how are u aakash";

        // Eleven Labs API settings
        String apiKey = "sk_0dd601f66cd92a60402b7187592f010147d8dbee43ae69f0";
        String voiceId = "9BWtsMINqrJLrRacOk9x";
        String modelId = "eleven_multilingual_v1";
        double similarityBoost = 0.75;
        double stability = 0.5;
        int style = 0;

        // Prepare API request
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.elevenlabs.io/v1/text-to-speech/" + voiceId;

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("xi-api-key", apiKey);

        // Create JSON body
        String requestBody = String.format(
                "{ \"model_id\": \"%s\", \"text\": \"%s\", \"voice_settings\": { \"stability\": %f, \"similarity_boost\": %f, \"style\": %d } }",
                modelId, storyContent, stability, similarityBoost, style
        );

        // Create an HttpEntity with the headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, byte[].class);

        // Handle the response
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            // Set response headers
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            responseHeaders.setContentDispositionFormData("attachment", planet + "_story.mp3");

            // Return the audio file
            return new ResponseEntity<>(response.getBody(), responseHeaders, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to generate audio: " + response.getStatusCode());
        }
    }


}
