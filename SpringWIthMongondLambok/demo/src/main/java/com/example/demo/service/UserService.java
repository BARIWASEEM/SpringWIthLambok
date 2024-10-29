package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository appUserRepository;
    
    
    
    
    ///post

    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }
    
    
    //get

    public Optional<AppUser> getUserById(ObjectId id) {
        return appUserRepository.findById(id);
    }

    public Optional<AppUser> getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public AppUser updateUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public void deleteUser(ObjectId id) {
        appUserRepository.deleteById(id);
    }
}
