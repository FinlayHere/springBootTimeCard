package com.ThoughtWorks.springBootTimeCard.annotation;

import com.ThoughtWorks.springBootTimeCard.validator.WorkTimeConstrainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WorkTimeConstrainValidator.class)
public @interface WorkTimeConstrain {
    String message() default "The number of work time should between 40 and 56 hours";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
