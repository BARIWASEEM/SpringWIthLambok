package com.example.demo.controller;

import com.example.demo.model.JournalEntry;
import com.example.demo.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/{userId}/journalentry")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<JournalEntry> createJournalEntry(@PathVariable ObjectId userId, @RequestBody JournalEntry entry) {
        entry.setUserId(userId);
        return ResponseEntity.ok(journalEntryService.createJournalEntry(entry));
    }

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getJournalEntries(@PathVariable ObjectId userId) {
        return ResponseEntity.ok(journalEntryService.getJournalEntriesByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId userId, @PathVariable ObjectId id) {
        Optional<JournalEntry> entry = journalEntryService.getJournalEntryById(id);
        return entry.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId userId
    		, @PathVariable ObjectId id, @RequestBody JournalEntry updatedEntry) {
        Optional<JournalEntry> existingEntry = journalEntryService.getJournalEntryById(id);
        if (existingEntry.isPresent() && existingEntry.get().getUserId().equals(userId)) {
            updatedEntry.setId(id);
            updatedEntry.setUserId(userId);
            return ResponseEntity.ok(journalEntryService.updateJournalEntry(updatedEntry));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable ObjectId userId, @PathVariable ObjectId id) {
        journalEntryService.deleteJournalEntry(id);
        return ResponseEntity.noContent().build();
    }
}