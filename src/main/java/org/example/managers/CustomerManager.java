package org.example.managers;

import org.example.exceptions.ResourceAlredyExists;
import org.example.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author abhishekraj
 **/
public class CustomerManager {
    Map<Integer, User> userMap;

    public CustomerManager() {
        this.userMap = new HashMap<>();
    }

    public void addUser(int id, String name) throws ResourceAlredyExists{
        if(userMap.get(id)!=null){
            throw new ResourceAlredyExists("User Already exists");
        }
        userMap.put(id, new User(id, name));
    }

    public User getUser(int id){
        return userMap.get(id);
    }

}
