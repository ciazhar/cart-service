package com.ciazhar.springwebfluxcommandpattern.validation;

import com.ciazhar.springwebfluxcommandpattern.validation.validator.ProductQuantityMustEnoughValidator;
import com.ciazhar.springwebfluxcommandpattern.validation.validator.ProductQuantityUpdateMustEnoughValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ciazhar on 11/7/17.
 * <p>
 * [ Documentation Here ]
 */
@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {
        ProductQuantityMustEnoughValidator.class,
        ProductQuantityUpdateMustEnoughValidator.class
})
@Documented
public @interface ProductQuantityMustEnough {

    String message() default "ProductQuantityMustEnough";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

    interface ProductQuantity {

        String getProductId();

        Integer getQuantity();

    }

    interface ProductQuantityUpdate {

        String getCartId();

        String getProductId();

        Integer getQuantity();

    }

}

