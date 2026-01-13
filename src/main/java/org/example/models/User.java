package org.example.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abhishekraj
 **/

public class User {
    private final int id;
    private String name;
    private List<Order> orders;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
