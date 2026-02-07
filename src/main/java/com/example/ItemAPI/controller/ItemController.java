package com.example.ItemAPI.controller;

import com.example.ItemAPI.model.Item;
import com.example.ItemAPI.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // Root endpoint
    @GetMapping("/")
    public String home() {
        return "ItemAPI is running!";
    }

    // Health check endpoint
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    // Add a new item
    @PostMapping("/api/items")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    // Get an item by ID
    @GetMapping("/api/items/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        Item item = service.getItemById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    // Custom error handler for all unmapped URLs
    @GetMapping("/error")
    public String handleError() {
        return "Custom Error: Page not found!";
    }
}
