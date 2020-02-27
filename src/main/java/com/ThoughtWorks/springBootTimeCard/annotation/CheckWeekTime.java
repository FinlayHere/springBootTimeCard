package com.ThoughtWorks.springBootTimeCard.annotation;

import javax.validation.constraints.Max;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fanchaokong
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckWeekTime {

    String message() default "{com.ThoughtWorks.springBootTimeCard.annotation.CheckWeekTime}";

    int Min() default 40;

    int Max() default 56;

}