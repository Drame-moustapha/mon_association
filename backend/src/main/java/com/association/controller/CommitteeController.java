package com.association.controller;

import com.association.entity.Committee;
import com.association.repository.CommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/committees")
public class CommitteeController {

    @Autowired
    private CommitteeRepository committeeRepository;

    @GetMapping
    public List<Committee> list() {
        return committeeRepository.findAll();
    }

    @PostMapping
    public Committee create(@RequestBody Committee c) {
        return committeeRepository.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Committee c) {
        return committeeRepository.findById(id).map(existing -> {
            existing.setName(c.getName());
            existing.setDescription(c.getDescription());
            committeeRepository.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!committeeRepository.existsById(id)) return ResponseEntity.notFound().build();
        committeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
