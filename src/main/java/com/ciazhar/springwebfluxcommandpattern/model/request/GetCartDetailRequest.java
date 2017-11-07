package com.ciazhar.springwebfluxcommandpattern.model.request;

import com.ciazhar.springwebfluxcommandpattern.validation.CartMustExists;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
public class GetCartDetailRequest {
    @CartMustExists
    private String cartId;

    public String getCartId() {
        return cartId;
    }
}
