package com.movierecommendationbot.controller;

import com.movierecommendationbot.model.Preference;
import com.movierecommendationbot.service.PreferencesService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/preferences")
public class PreferencesController {

    private final PreferencesService preferencesService;

    public PreferencesController(PreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }

    @GetMapping
    public Mono<Preference> getUserPreferences(@RequestParam String userId) {
        return preferencesService.getPreferences(userId);
    }

    @PostMapping
    public Mono<String> updateUserPreferences(@RequestParam String userId, @RequestBody Preference preference) {
        return preferencesService.updatePreferences(userId, preference)
                .map(user -> "Preferences updated successfully!");
    }
}
