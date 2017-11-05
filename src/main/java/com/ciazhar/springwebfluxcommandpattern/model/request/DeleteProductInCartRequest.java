package com.ciazhar.springwebfluxcommandpattern.model.request;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

public class DeleteProductInCartRequest {
    private String cartId;
    private String productId;

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }
}
