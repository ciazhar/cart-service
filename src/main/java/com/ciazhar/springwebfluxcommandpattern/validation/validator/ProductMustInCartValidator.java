package com.ciazhar.springwebfluxcommandpattern.validation.validator;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Cart;
import com.ciazhar.springwebfluxcommandpattern.repository.CartRepository;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustInCart;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ciazhar on 11/7/17.
 * <p>
 * [ Documentation Here ]
 */
public class ProductMustInCartValidator implements ConstraintValidator<ProductMustInCart,ProductMustInCart.ProductInCart> {

    @Autowired private CartRepository cartRepository;

    @Override
    public void initialize(ProductMustInCart constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductMustInCart.ProductInCart value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Cart cart = cartRepository.findById(value.getCartId()).block();
        if (cart == null) {
            return true;
        }

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            return false;
        }

        return cart.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(value.getProductId()));
    }
}
