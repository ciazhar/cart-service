package com.ciazhar.springwebfluxcommandpattern.model.request;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@Data
@Builder
public class AddProductToCartRequest {
    private String cartId;
    private String productId;
    private Integer quantity;

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
