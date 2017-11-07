package com.ciazhar.springwebfluxcommandpattern.model.request;

import com.ciazhar.springwebfluxcommandpattern.validation.CartMustExists;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustExists;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustInCart;

import javax.validation.constraints.NotNull;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

public class UpdateProductInCartRequest {
    @CartMustExists
    private String cartId;
    @ProductMustExists
    @ProductMustInCart
    private String productId;
    @NotNull
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
