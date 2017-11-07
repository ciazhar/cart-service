package com.ciazhar.springwebfluxcommandpattern.validation.validator;

import com.ciazhar.springwebfluxcommandpattern.repository.CartRepository;
import com.ciazhar.springwebfluxcommandpattern.validation.CartMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
public class CartMustNotExistsValidator implements ConstraintValidator<CartMustNotExists,String> {

    @Autowired private CartRepository repository;

    @Override
    public void initialize(CartMustNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null){
            return true;
        }
        return !repository.existsById(value).block();
    }
}
