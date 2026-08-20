package com.greg.service;

import com.greg.model.User;
import java.util.UUID;


public class UserService {

    public User idLookUp (String ID) {
        String randomName = UUID.randomUUID().toString();
        return new User(ID, randomName);
    }
}
