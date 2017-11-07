package com.ciazhar.springwebfluxcommandpattern.model.request;

import com.ciazhar.springwebfluxcommandpattern.validation.CartMustExists;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustExists;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@Data
@Builder
public class AddProductToCartRequest {

    @CartMustExists
    private String cartId;
    @ProductMustExists
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
