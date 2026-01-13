package org.example.query;

import org.example.models.Item;

/**
 * @author abhishekraj
 **/
public interface Query {
    public boolean matches(Item item);
}
