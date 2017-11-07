package com.ciazhar.springwebfluxcommandpattern.validation.validator;

import com.ciazhar.springwebfluxcommandpattern.repository.ProductRepository;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductMustExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

public class ProductMustExistsValidator implements ConstraintValidator <ProductMustExists,String>{

    @Autowired private ProductRepository repository;

    @Override
    public void initialize(ProductMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null){
            return true;
        }
        return repository.existsById(value).block();
    }
}
