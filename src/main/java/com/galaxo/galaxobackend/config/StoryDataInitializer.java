package com.galaxo.galaxobackend.config;


import com.galaxo.galaxobackend.model.Story;
import com.galaxo.galaxobackend.services.StoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoryDataInitializer {


    @Bean
    public CommandLineRunner initStory(StoryService storyService) {
        return args -> {
            // Initialize sample stories
            initializeStory(storyService, "Kepler-22b: The Blue-Green World Beyond the Stars",
                    "Once upon a time, far beyond the shining stars in the night sky, there was a very special planet called Kepler-22b. Kepler-22b was unlike Earth, the planet we live on, but it was still fascinating in its own magical way. In fact, it was the first planet scientists found that circled around a star much like our Sun, in what they call the \"habitable zone.\" This special zone means that the planet could be just the right temperature to have liquid water, which is important for life, just like the water we have on Earth!\n" +
                            "\n" +
                            "But let me tell you the story of how Kepler-22b was discovered.\n" +
                            "\n" +
                            "Many years ago, a group of smart people called astronomers were looking at the night sky with a space telescope named Kepler. It was named after a famous scientist, Johannes Kepler, who loved studying the stars. Kepler the telescope was sent on a mission to find new planets that might be hiding among the stars. And one day, after searching and searching, Kepler found something incredible – a new planet!\n" +
                            "\n" +
                            "This planet was far, far away from us, about 600 light-years away in a distant part of the sky. But even though it was so far, Kepler and the astronomers were able to figure out many things about it. They named it Kepler-22b, after the telescope that found it.\n" +
                            "\n" +
                            "Kepler-22b is much bigger than Earth—almost 2.4 times the size, in fact! But what really makes Kepler-22b exciting is that it is in that magical \"habitable zone\" I mentioned earlier. Scientists think this could mean that there’s the possibility of water, and where there’s water, there might even be life, like plants or animals, though no one knows for sure yet.\n" +
                            "\n" +
                            "But Kepler-22b is not exactly like Earth. For one thing, we don’t know what its surface looks like. It could be covered in oceans, or it might have clouds floating high above it. And while the days are a bit longer than ours, a year on Kepler-22b is shorter—just 290 days! That means if you lived on Kepler-22b, your birthday would come a little sooner every year.\n" +
                            "\n" +
                            "Now, Kepler-22b orbits a star that is a lot like our Sun. Imagine if you could stand on the surface of this distant planet and look up at the sky. You would see a sun that shines bright and warm, just like our own. The star is called Kepler-22, and it helps keep the planet warm enough that it might feel nice and comfortable there, just like a pleasant spring day here on Earth.\n" +
                            "\n" +
                            "As the astronomers studied more about this fascinating planet, they began to wonder: Could there be other planets like Kepler-22b out there? Planets where people, animals, or strange new creatures could live? The discovery of Kepler-22b gave everyone hope that maybe, just maybe, we are not alone in the universe.\n" +
                            "\n" +
                            "So, the next time you look up at the night sky and see all the twinkling stars, remember that out there, far beyond what we can see with our own eyes, there are amazing places like Kepler-22b waiting to be explored. And who knows? Maybe one day, we'll travel to Kepler-22b and discover all the wonderful secrets it holds.",
                    "Kepler-22b");
            initializeStory(storyService, "The Adventure to TOI-700 d: A New World",
                    "Once upon a time, far, far away in space, there was a very special planet called TOI-700 d. This planet is amazing because it orbits in the \"habitable zone\" of its star, which means it might be just the right temperature for life, just like Earth!\n" +
                            "\n" +
                            "A smart space telescope named TESS discovered TOI-700 d. The planet is about 100 light-years away from us, so it's super far, but TESS was able to find it by looking closely at a star called TOI-700. It’s a small, cool star, much dimmer than our Sun. TOI-700 d is the perfect distance from its star to not be too hot or too cold—just like Goldilocks' porridge!\n" +
                            "\n" +
                            "TOI-700 d is a bit bigger than Earth, but no one knows what it looks like yet. Maybe it has oceans, mountains, or even clouds. Some scientists believe that if we could visit, we might find plants or even strange animals!\n" +
                            "\n" +
                            "Even though it’s far away, the discovery of TOI-700 d gives us hope that there could be other planets just like Earth out there, waiting for us to explore.\n" +
                            "\n" +
                            "So next time you look up at the stars, remember: there's a whole universe filled with incredible planets, and TOI-700 d is one of the most exciting of them all!",
                    "TOI-700 d");
        };
    }

    private void initializeStory(StoryService storyService, String title, String content, String planet) {
        String filePath = storyService.saveStoryToFile(planet, content);
        if (filePath != null) {
            Story story = new Story(title, planet, filePath);
            storyService.setStory(story);
        } else {
            System.err.println("Failed to save story file for planet: " + planet);
        }
    }

}