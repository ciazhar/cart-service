package com.ciazhar.springwebfluxcommandpattern.model.request;

import com.ciazhar.springwebfluxcommandpattern.validation.CartMustExists;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustExists;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustInCart;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

public class DeleteProductInCartRequest {
    @CartMustExists
    private String cartId;
    @ProductMustInCart
    @ProductMustExists
    private String productId;

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }
}
