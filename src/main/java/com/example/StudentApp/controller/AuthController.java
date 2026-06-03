package com.example.StudentApp.controller;

import com.example.StudentApp.dto.RegisterRequest;
import com.example.StudentApp.entity.User;
import com.example.StudentApp.repository.UserRepository;
import com.example.StudentApp.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Username already exists"));
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return ResponseEntity.ok(
                Map.of("message", "User registered successfully")
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            body.get("username"),
                            body.get("password")
                    )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }

        String token = jwtUtil.generateToken(body.get("username"));
        return ResponseEntity.ok(Map.of("token", token));
    }

}