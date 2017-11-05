package com.ciazhar.springwebfluxcommandpattern.model;

import lombok.Builder;
import lombok.Data;

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
}
