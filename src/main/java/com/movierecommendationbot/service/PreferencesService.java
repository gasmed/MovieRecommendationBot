package com.movierecommendationbot.service;

import com.movierecommendationbot.model.Preference;
import com.movierecommendationbot.model.User;
import com.movierecommendationbot.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PreferencesService {

    private final UserRepository userRepository;

    public PreferencesService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> updatePreferences(String userId, Preference newPreferences) {
        return userRepository.findById(userId)
                .flatMap(user -> {
                    user.setPreferences(newPreferences);
                    return userRepository.save(user);
                });
    }

    public Mono<Preference> getPreferences(String userId) {
        return userRepository.findById(userId)
                .map(User::getPreferences);
    }
}
