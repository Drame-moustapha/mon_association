package com.association.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; // stocker hash

    private String firstName;
    private String lastName;
    private String phone;
    private boolean active = true;
    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
