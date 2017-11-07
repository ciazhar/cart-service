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

    public List<CartItem> getItems() {
        if (items == null){
            new ArrayList<>();
        }
        return items;
    }
}
