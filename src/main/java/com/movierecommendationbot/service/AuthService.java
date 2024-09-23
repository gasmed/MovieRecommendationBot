package com.movierecommendationbot.service;

import com.movierecommendationbot.model.User;
import com.movierecommendationbot.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> signUp(String username, String password) {
        User user = new User(username, password); // Нужно шифровать пароль
        return userRepository.save(user);
    }

    public Mono<User> signIn(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }
}
