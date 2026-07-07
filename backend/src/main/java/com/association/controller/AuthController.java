package com.association.controller;

import com.association.entity.Role;
import com.association.entity.User;
import com.association.repository.RoleRepository;
import com.association.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // NOTE: inscription via admin only - endpoint to create users (admin-protected later)
    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("username_taken");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("email_taken");
        }

        // assign role if provided, otherwise ROLE_MEMBER
        Role role = roleRepository.findByName(user.getRole() != null ? user.getRole().getName() : "ROLE_MEMBER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_MEMBER")));
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    // simple login placeholder - to be replaced by JWT implementation
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User login) {
        Optional<User> u = userRepository.findByUsername(login.getUsername());
        if (u.isEmpty()) return ResponseEntity.status(401).body("invalid_credentials");
        if (!passwordEncoder.matches(login.getPassword(), u.get().getPassword())) return ResponseEntity.status(401).body("invalid_credentials");
        // TODO: return JWT token
        return ResponseEntity.ok(u.get());
    }
}
