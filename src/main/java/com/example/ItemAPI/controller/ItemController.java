    package com.example.ItemAPI.controller;
    
    
    
    import com.example.ItemAPI.model.Item;
    import com.example.ItemAPI.service.ItemService;
    import jakarta.validation.Valid;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    @RestController
    @RequestMapping("/api/items")
    public class ItemController {
    
        private final ItemService service;
    
        public ItemController(ItemService service) {
            this.service = service;
        }
    
    
        @PostMapping
        public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
            return ResponseEntity.ok(service.addItem(item));
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<?> getItem(@PathVariable Long id) {
            Item item = service.getItemById(id);
    
            if (item == null) {
                return ResponseEntity.notFound().build();
            }
    
            return ResponseEntity.ok(item);
        }
        @GetMapping("/")
        public String home() {
            return "API is running successfully";
        }

    }
