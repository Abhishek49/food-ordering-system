package org.example;

import org.example.models.Item;
import org.example.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abhishekraj
 **/
public class QueryBuilder {

    List<Query> queries;

    public QueryBuilder() {
        this.queries = new ArrayList<>();
    }

    public void addQuery(Query query){
        queries.add(query);
    }

    public List<Item> matches(List<Item> items){
        boolean isMatch = true;
        List<Item> result = new ArrayList<>();
        for(Item i: items){
            isMatch = true;
            for(Query q: this.queries){
                if(!q.matches(i)){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                result.add(i);
            }
        }
       return result;
    }
}
