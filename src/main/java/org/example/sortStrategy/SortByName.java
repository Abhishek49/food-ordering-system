package org.example.sortStrategy;

import org.example.models.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author abhishekraj
 **/
public class SortByName implements SortStrategy{

    @Override
    public List<Item> sortAscending(List<Item> items) {
        return items.stream().sorted(Comparator.comparing(Item::getName)).toList();
    }

    @Override
    public List<Item> sortDescending(List<Item> items) {
        return items.stream().sorted((a,b)-> b.getName().compareTo(a.getName())).toList();
    }
}
