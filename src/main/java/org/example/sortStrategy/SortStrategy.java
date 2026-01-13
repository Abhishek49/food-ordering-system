package org.example.sortStrategy;

import org.example.models.Item;

import java.util.List;

/**
 * @author abhishekraj
 **/
public interface SortStrategy {
    public List<Item> sortAscending(List<Item> items);
    public List<Item> sortDescending(List<Item> items);
}
