package org.example.managers;

import org.example.exceptions.ResourceAlredyExists;
import org.example.exceptions.ResourceNotFound;
import org.example.models.Item;
import org.example.models.Restaurant;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abhishekraj
 **/
public class RestaurantManager {
    Map<Integer, Restaurant> restaurantMap;

    public RestaurantManager() {
        restaurantMap = new HashMap<>();
    }

    public void addRestaurant(int id, String name) throws ResourceAlredyExists {
        if(restaurantMap.get(id)!=null){
            throw new ResourceAlredyExists("User Already exists");
        }
        restaurantMap.put(id, new Restaurant(id, name));
    }

    public void addItem(int restaurantId, int itemId, BigDecimal cost, String name, int quantity){
        try{
            Restaurant restaurant = restaurantMap.get(restaurantId);
            if (restaurant==null){
                throw  new ResourceNotFound("Restaurant not found");
            }
            restaurant.addItem(itemId, quantity, cost, name, 100);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Restaurant getRestaurant(Integer restaurantId){
        return restaurantMap.get(restaurantId);
    }

}
