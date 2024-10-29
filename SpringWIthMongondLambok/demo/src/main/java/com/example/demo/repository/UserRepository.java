package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, ObjectId> {
    Optional<AppUser> findByUsername(String username);
}
