package com.ciazhar.springwebfluxcommandpattern.model.request;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

public class UpdateProductInCartRequest {
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
