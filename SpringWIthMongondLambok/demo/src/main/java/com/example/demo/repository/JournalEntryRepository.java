package com.example.demo.repository;

import com.example.demo.model.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    List<JournalEntry> findByUserId(ObjectId userId);
}