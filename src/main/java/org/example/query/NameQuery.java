package org.example.query;

import org.example.models.Item;

/**
 * @author abhishekraj
 **/
public class NameQuery implements Query{
    String itemName;

    public NameQuery(String itemName) {
        this.itemName = itemName;
    }

    public boolean matches(Item item){
        return item.getName().contains(this.itemName);
    }
}
