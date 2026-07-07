package com.association.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "committees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Comité sportif, etc.

    @Column(length = 2000)
    private String description;
}
