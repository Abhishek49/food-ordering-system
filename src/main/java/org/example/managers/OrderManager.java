package org.example.managers;

import org.example.exceptions.BadRequest;
import org.example.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abhishekraj
 **/
public class OrderManager {
    Map<Integer, Order> orderMap;

    public OrderManager() {
        this.orderMap = new HashMap<>();
    }

    public void createOrder(int id, List<OrderItem> items, User customer, Restaurant restaurant){
        //check if items are available
        try{
            for(OrderItem i: items){
                if(!restaurant.isItemAvailable(i)){
                    throw new BadRequest("not enough items");
                }
            }

            Order o = new Order(id, customer,  items, restaurant);
            customer.addOrder(o);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
