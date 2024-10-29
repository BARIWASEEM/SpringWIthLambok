package com.example.demo.service;

import com.example.demo.model.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public JournalEntry createJournalEntry(JournalEntry entry) {
        return journalEntryRepository.save(entry);
    }

    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public List<JournalEntry> getJournalEntriesByUserId(ObjectId userId) {
        return journalEntryRepository.findByUserId(userId);
    }

    public JournalEntry updateJournalEntry(JournalEntry entry) {
        return journalEntryRepository.save(entry);
    }

    public void deleteJournalEntry(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }
}
