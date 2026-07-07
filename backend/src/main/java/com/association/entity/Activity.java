package com.association.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private boolean published = false;

    @ManyToOne
    @JoinColumn(name = "committee_id")
    private Committee committee;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private Instant createdAt = Instant.now();
}
