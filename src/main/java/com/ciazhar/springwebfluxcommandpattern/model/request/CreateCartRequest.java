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
public class CreateCartRequest {
    private String cartId;

    public String getCartId() {
        return cartId;
    }
}
