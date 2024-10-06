//package com.galaxo.galaxobackend.config;
//
//import org.apache.catalina.filters.CorsFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
////@Configuration
////@EnableWebSecurity
////@EnableMethodSecurity
//public class SecurityConfig {
////    @Bean
////    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf(csrf -> csrf.disable())
////                .authorizeHttpRequests(authorizeRequests ->authorizeRequests.anyRequest().authenticated())
////
////                .oauth2Login (oauth2->oauth2.defaultSuccessUrl("http://localhost:5173/",true))
////
////                ;
////
////
////        return http.build();
////    }
//
////    @Bean
////    public CorsFilter corsFilter() {
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        CorsConfiguration config = new CorsConfiguration();
////        config.setAllowCredentials(true);
////        config.addAllowedOrigin("http://localhost:5173"); // Allow your frontend origin
////        config.addAllowedHeader("*");
////        config.addAllowedMethod("*"); // Allow all methods (GET, POST, etc.)
////        source.registerCorsConfiguration("/**", config);
////        return new CorsFilter();
////    }
//
//}
