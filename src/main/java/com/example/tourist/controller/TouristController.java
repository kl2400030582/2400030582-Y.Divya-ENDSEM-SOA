
package com.example.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    @Autowired
    private TouristRepository repository;

    // Add Tourist
    @PostMapping
    public Tourist addTourist(@RequestBody Tourist tourist) {
        return repository.save(tourist);
    }

    // Get Tourist
    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getTourist(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Tourist
    @PutMapping("/{id}")
    public ResponseEntity<Tourist> updateTourist(
            @PathVariable Long id,
            @RequestBody Tourist updatedTourist) {

        return repository.findById(id)
                .map(tourist -> {

                    tourist.setName(updatedTourist.getName());

                    tourist.setDestination(
                            updatedTourist.getDestination());

                    tourist.setContact(
                            updatedTourist.getContact());

                    Tourist saved = repository.save(tourist);

                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
