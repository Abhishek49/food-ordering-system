package org.example.models;

import java.math.BigDecimal;

/**
 * @author abhishekraj
 **/
public class Item {
    private final int  id;
    BigDecimal cost;
    String name;
    int quantity;
    int maxQuantity;

    public Item(int id, String name, BigDecimal cost, int quantity, int maxQuantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity){
        this.quantity -=quantity;
    }


    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
