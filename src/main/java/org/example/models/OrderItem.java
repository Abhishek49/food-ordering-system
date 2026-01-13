package org.example.models;

import java.math.BigDecimal;

/**
 * @author abhishekraj
 **/
public class OrderItem {
    private Item item;
    private BigDecimal cost;
    private Integer quantity;
    private String customization;

    public OrderItem(Item item, Integer quantity, String customization) {
        this.item = item;
        this.cost = item.getCost();
        this.quantity = quantity;
        this.customization = customization;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCustomization() {
        return customization;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
