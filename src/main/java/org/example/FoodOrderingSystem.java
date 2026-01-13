package org.example;

import org.example.exceptions.ResourceAlredyExists;
import org.example.exceptions.ResourceNotFound;
import org.example.managers.CustomerManager;
import org.example.managers.OrderManager;
import org.example.managers.RestaurantManager;
import org.example.models.Item;
import org.example.models.OrderItem;
import org.example.models.Restaurant;
import org.example.models.User;
import org.example.query.NameQuery;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author abhishekraj
 **/
public class FoodOrderingSystem {
    CustomerManager customerManager;
    OrderManager orderManager;
    RestaurantManager restaurantManager;


    public FoodOrderingSystem() {
        this.customerManager = new CustomerManager();
        this.orderManager = new OrderManager();
        this.restaurantManager = new RestaurantManager();
    }

    //add user
    public void addUser(int id, String name) {
        try{
            this.customerManager.addUser(id, name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    //add restaurant
    public void addRestaurant(int id, String name){
        try{
            this.restaurantManager.addRestaurant(id, name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //add items
    public void addItem(int restaurantId, int itemId, BigDecimal cost, String name, int quantity){

            restaurantManager.addItem(restaurantId,  itemId,  cost, name, quantity);

    }

    public void removeItem(int restaurantId, int itemId, BigDecimal cost, String name, int quantity){
        restaurantManager.addItem(restaurantId,  itemId,  cost, name, quantity);

    }

    //Search
    public List<Item> search(int restaurantId, String name){
        Restaurant restaurant = restaurantManager.getRestaurant(restaurantId);
        List<Item> items = restaurant.getItems();
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.addQuery(new NameQuery("dal"));
        return queryBuilder.matches(items);
    }
    
    //add order

    public void createOrder(int orderId, List<OrderItem> items, User customer, Restaurant restaurant){
        this.orderManager.createOrder(orderId, items, customer, restaurant);
    }



    //getUser
    //getOrder
    //getRestaurant
    //createOrder
}
