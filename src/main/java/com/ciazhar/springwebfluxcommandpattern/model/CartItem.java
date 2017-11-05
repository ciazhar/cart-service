package com.ciazhar.springwebfluxcommandpattern.model;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Product;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */


@Data
@Builder
public class CartItem {
    private String id;
    private String name;
    private Long price;
    private Integer quantity;

    public CartItem(String id, String name, Long price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
