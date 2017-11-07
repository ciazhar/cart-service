package com.ciazhar.springwebfluxcommandpattern.validation;

import com.ciazhar.springwebfluxcommandpattern.validation.validator.ProductMustExistsValidator;
import com.ciazhar.springwebfluxcommandpattern.validation.validator.ProductMustInCartValidator;

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
@Constraint(validatedBy = {ProductMustInCartValidator.class})
@Documented
public @interface ProductMustInCart {
    String message() default "ProductMustInCart";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

    interface ProductInCart {

        String getCartId();

        String getProductId();

    }

}
