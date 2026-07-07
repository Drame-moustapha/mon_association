package com.association.controller;

import com.association.entity.Activity;
import com.association.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping
    public List<Activity> list() {
        return activityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return activityRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Activity create(@RequestBody Activity a) {
        return activityRepository.save(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Activity a) {
        return activityRepository.findById(id).map(existing -> {
            existing.setTitle(a.getTitle());
            existing.setDescription(a.getDescription());
            existing.setStartDate(a.getStartDate());
            existing.setEndDate(a.getEndDate());
            existing.setLocation(a.getLocation());
            existing.setPublished(a.isPublished());
            activityRepository.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!activityRepository.existsById(id)) return ResponseEntity.notFound().build();
        activityRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
