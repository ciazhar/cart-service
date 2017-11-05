package com.ciazhar.springwebfluxcommandpattern.model.mongo;

import com.ciazhar.springwebfluxcommandpattern.model.CartItem;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
@Data
@Builder
@Document
public class Cart {
    @Id
    private String id;
    private List<CartItem> items = new ArrayList<>();

    public Cart(String id, List<CartItem> items) {
        this.id = id;
        this.items = items;
    }

    public Cart(String cartId) {
        this.items = new ArrayList<>();
        this.id = cartId;
    }

    public String getId() {
        return id;
    }

    public List<CartItem> getItems() {
        if (items == null){
            new ArrayList<>();
        }
        return items;
    }
}
