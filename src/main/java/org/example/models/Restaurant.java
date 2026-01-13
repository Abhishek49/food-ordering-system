package org.example.models;

import org.example.exceptions.ResourceAlredyExists;
import org.example.exceptions.ResourceNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

/**
 * @author abhishekraj
 **/
public class Restaurant {
    int id;
    String name;

    Map<Integer, Item> itemMap;
    List<Order> orders;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        itemMap = new HashMap<>();
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

    public void addItem(int itemId, Integer quantity, BigDecimal cost, String name, Integer maxQuantity)throws ResourceAlredyExists{
        Item item = itemMap.get(itemId);
        if(item == null){
            itemMap.put(itemId, new Item(itemId, name, cost, quantity, maxQuantity));
        }else {
            throw new ResourceAlredyExists("Item exists");
        }
    }

    public void removeItem(int itemId)throws ResourceNotFound{
        Item item = itemMap.get(itemId);
        if(item == null){
            throw new ResourceNotFound("Item not found");
        }else {
            itemMap.remove(itemId);
        }
    }

    public Item getItem(int itemId)throws ResourceNotFound{
        Item item = itemMap.get(itemId);
        if(item == null){
            throw new ResourceNotFound("Item not found");
        }else {
            return item;
        }
    }

    public List<Item> getItems(){
        return this.itemMap.values().stream().toList();
    }

    public Boolean isItemAvailable(OrderItem item) throws ResourceNotFound {
        Item restaurantItem = itemMap.get(item.getItem().getId());
        if(restaurantItem == null){
            throw new ResourceNotFound("no such item:"+ item.getItem().getId());
        }
        return restaurantItem.getQuantity()>=item.getQuantity();
    }

    public void addOrder(Order o){
        List<OrderItem> items = o.getOrderItems();
        for(OrderItem i : items){
            this.itemMap.get(i.getItem().getId()).decreaseQuantity(i.getQuantity());
        }
        this.orders.add(o);
    }


//    public void editItem(int itemId)throws ResourceNotFound{
//        Item item = itemMap.get(itemId);
//        if(item == null){
//            throw new ResourceNotFound("Item not found");
//        }else {
//            itemMap.remove(itemId);
//        }
//    }



}
