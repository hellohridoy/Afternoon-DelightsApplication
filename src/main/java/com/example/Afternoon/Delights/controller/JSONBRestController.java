package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.JSONB;
import com.example.Afternoon.Delights.service.JSONBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JSONBRestController {
    private final JSONBService jsonBService;

    // Create a new JSONB entry
    @PostMapping("/v1/api/learn-jsonb/jsob-response")
    public ResponseEntity<JSONB> createJSONB(@RequestBody JSONB jsonbExample) {
        JSONB createdJSONB = jsonBService.createJSONB(jsonbExample);
        return ResponseEntity.ok(createdJSONB);
    }

    // Get all JSONB entries
    @GetMapping("/v1/api/learn-jsonb/jsob-response")
    public ResponseEntity<List<JSONB>> getAllJSONB() {
        List<JSONB> jsonbExamples = jsonBService.getAllJSONB();
        return ResponseEntity.ok(jsonbExamples);
    }

    // Get a single JSONB entry by ID
    @GetMapping("/v1/api/learn-jsonb/jsob-response/{id}")
    public ResponseEntity<JSONB> getJSONBById(@PathVariable Long id) {
        JSONB jsonbExample = jsonBService.getJSONBById(id);
        if (jsonbExample == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jsonbExample);
    }

    // Update a JSONB entry by ID
    @PutMapping("/v1/api/learn-jsonb/jsob-response/{id}")
    public ResponseEntity<JSONB> updateJSONB(@PathVariable Long id, @RequestBody JSONB jsonbExample) {
        JSONB updatedJSONB = jsonBService.updateJSONB(id, jsonbExample);
        if (updatedJSONB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJSONB);
    }

    // Delete a JSONB entry by ID
    @DeleteMapping("/v1/api/learn-jsonb/jsob-response/{id}")
    public ResponseEntity<Void> deleteJSONB(@PathVariable Long id) {
        jsonBService.deleteJSONB(id);
        return ResponseEntity.noContent().build();
    }
}
