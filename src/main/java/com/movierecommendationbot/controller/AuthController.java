package com.movierecommendationbot.controller;

import com.movierecommendationbot.model.User;
import com.movierecommendationbot.service.AuthService;
import com.movierecommendationbot.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public Mono<String> signUp(@RequestParam String username, @RequestParam String password) {
        return authService.signUp(username, password)
                .map(user -> jwtUtil.generateToken(user.getUsername()));
    }

    @PostMapping("/signin")
    public Mono<String> signIn(@RequestParam String username, @RequestParam String password) {
        return authService.signIn(username, password)
                .map(user -> jwtUtil.generateToken(user.getUsername()));
    }
}
