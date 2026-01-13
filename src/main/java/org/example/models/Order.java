package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author abhishekraj
 **/
public class Order {
    private final int id;
    private final User customer;
    private final List<OrderItem> orderItems;
    private final Restaurant restaurant;
    private OrderStatus orderStatus;

    public Order(Integer id, User customer, List<OrderItem> orderItems, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.orderItems = List.copyOf(orderItems);
        this.restaurant = restaurant;
        this.orderStatus = OrderStatus.PLACED;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
