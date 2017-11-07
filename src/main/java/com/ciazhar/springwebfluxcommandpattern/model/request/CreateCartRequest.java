package com.ciazhar.springwebfluxcommandpattern.model.request;

import com.ciazhar.springwebfluxcommandpattern.validation.CartMustNotExists;
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
    @CartMustNotExists
    private String cartId;

    public String getCartId() {
        return cartId;
    }
}
