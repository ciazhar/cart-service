package com.ciazhar.springwebfluxcommandpattern.validation;

import com.ciazhar.springwebfluxcommandpattern.validation.validator.CartMustExistsValidator;
import com.ciazhar.springwebfluxcommandpattern.validation.validator.CartMustNotExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CartMustNotExistsValidator.class})
@Documented
public @interface CartMustNotExists {
    String message() default "CartMustNotExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

}
