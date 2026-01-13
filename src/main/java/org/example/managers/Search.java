package org.example.managers;

import org.example.QueryBuilder;
import org.example.models.Item;
import org.example.models.Restaurant;
import org.example.query.Query;
import org.example.sortStrategy.SortStrategy;

import java.util.List;

/**
 * @author abhishekraj
 **/
public class Search {
    SortStrategy sortStrategy;

    public Search(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<Item> sort( List<Item> items, Boolean isAscending){
        if(isAscending){
            return sortStrategy.sortAscending(items);
        }else{
           return sortStrategy.sortDescending(items);
        }
    }

    public List<Item> search(Restaurant restaurant, QueryBuilder query){
        return this.sort(query.matches(restaurant.getItems()), true);
    }
}
