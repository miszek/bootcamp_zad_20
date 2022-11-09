package com.michalszekalski.bootcamp_zad_20;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private final List<User> userRepo = new ArrayList<>();

    public UserRepo() {
        this.userRepo.add(new User("Adam", "Kowalski", 34));
        this.userRepo.add(new User("Jan", "Nowak", 47));
        this.userRepo.add(new User("Anna", "Makowska", 24));
    }

    public List<User> getAll() {
        return userRepo;
    }

    public void add (User user) {
        userRepo.add(user);
    }
}


