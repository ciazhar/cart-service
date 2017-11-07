package com.ciazhar.springwebfluxcommandpattern.validation.validator;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Product;
import com.ciazhar.springwebfluxcommandpattern.repository.ProductRepository;
import com.ciazhar.springwebfluxcommandpattern.validation.ProductQuantityMustEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ciazhar on 11/7/17.
 * <p>
 * [ Documentation Here ]
 */
@Component
public class ProductQuantityMustEnoughValidator implements
        ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductQuantityMustEnough constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductQuantityMustEnough.ProductQuantity value, ConstraintValidatorContext context) {
        if (value == null || value.getProductId() == null || value.getQuantity() == null) {
            return true;
        }

        Product product = productRepository.findById(value.getProductId()).block();

        if (isProductNotExists(product)) {
            return true;
        }

        return isStockEnough(product, value.getQuantity());
    }

    private boolean isProductNotExists(Product product) {
        return product == null;
    }

    private boolean isStockEnough(Product product, Integer quantity) {
        return product.getStock() >= quantity;
    }
}
