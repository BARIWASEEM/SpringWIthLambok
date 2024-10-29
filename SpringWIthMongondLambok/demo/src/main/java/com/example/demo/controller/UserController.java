package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService appUserService;

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        return ResponseEntity.ok(appUserService.createUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUser> getUserByUsername(@PathVariable String username) {
        Optional<AppUser> user = appUserService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable ObjectId id, @RequestBody AppUser updatedUser) {
        Optional<AppUser> existingUser = appUserService.getUserById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return ResponseEntity.ok(appUserService.updateUser(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
