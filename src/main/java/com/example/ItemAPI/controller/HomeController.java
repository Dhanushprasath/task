package com.example.ItemAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    // Root endpoint
    @GetMapping({"", "/"})
    public String home() {
        return "ItemAPI is running!";
    }

    // Health check endpoint
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
