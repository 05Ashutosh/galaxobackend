package com.galaxo.galaxobackend.config;



import com.galaxo.galaxobackend.model.ExoPlanet;
import com.galaxo.galaxobackend.services.ExoPlanetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ExoPlanetServices exoPlanetServices) {
        return args -> {
            exoPlanetServices.setExoPlanet(new ExoPlanet("Kepler-22b",
                    "https://upload.wikimedia.org/wikipedia/commons/d/d2/Kepler-22b_versus_Earth.jpg",
                    "Kepler-22b was the first planet discovered in the 'habitable zone' of a sun-like star."
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("TOI-700 d",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/PIA23408-Exoplanet-TOI700d-20200106.jpg/435px-PIA23408-Exoplanet-TOI700d-20200106.jpg",
                    "Discovered by the TESS mission, TOI-700 d is an Earth-sized planet located in the habitable zone of its star, TOI-700, around 100 light-years away. "
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("Trappist-1 System",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/The_Sun_and_TRAPPIST-1.jpg/1280px-The_Sun_and_TRAPPIST-1.jpg",
                    "Located about 40 light-years away in the constellation Cetus, this super-Earth orbits in the habitable zone of a red dwarf star."
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("Kepler-1649c",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Kepler-1649_bc.jpg/1920px-Kepler-1649_bc.jpg",
                    "A rocky, Earth-sized planet located 300 light-years away, Kepler-1649c is in the habitable zone of its star. "
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("HD 209458 b (Osiris)",
                    "https://upload.wikimedia.org/wikipedia/commons/8/84/Osiris_%28HD209458b%29_planet_illustration.jpeg",
                    "This was the first exoplanet found transiting its host star, about 150 light-years away. It's a gas giant similar to Jupiter but much closer to its star, making it a 'hot Jupiter.'"
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("55 Cancri e",
                    "https://upload.wikimedia.org/wikipedia/commons/5/5f/Exoplanet_Comparison_HD_209458_b.png",
                    "Located about 40 light-years away, 55 Cancri e is a super-Earth that’s much larger than our planet but orbits its star very closely. "
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("Kepler-186f",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Kepler186f-ArtistConcept-20140417.jpg/1920px-Kepler186f-ArtistConcept-20140417.jpg",
                    "The first Earth-sized planet discovered in the habitable zone of another star. It's only about 10% larger than Earth and located 500 light-years away."
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("Kepler-452b",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Kepler-452b_artist_concept.jpg/1920px-Kepler-452b_artist_concept.jpg",
                    "Often dubbed 'Earth’s cousin,' this exoplanet is 1.5 times the size of Earth and located in the habitable zone of a Sun-like star."
            ));

            exoPlanetServices.setExoPlanet(new ExoPlanet("GJ 1214b",
                    "https://upload.wikimedia.org/wikipedia/commons/f/fe/Exoplanet_Comparison_GJ_1214_b.png",
                    "A 'mini-Neptune' located about 40 light-years away in the constellation Ophiuchus. It's a super-Earth with a thick atmosphere, likely composed of water vapor or a mixture of gases."
                    ));
            exoPlanetServices.setExoPlanet(new ExoPlanet("Kepler-16b",
                    "https://upload.wikimedia.org/wikipedia/commons/1/15/Kepler16b.gif",
                    "This system has five Earth-sized exoplanets that are all smaller than Venus and orbit a star 117 light-years away in the constellation Lyra."
            ));
        };
    }
}
