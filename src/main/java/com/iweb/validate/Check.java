package com.iweb.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * -------------------------------------------------
 *
 * @InterfaceName Check
 * @Auther xiaopeng
 * @Date 2019/2/18 10:05
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Check {

    String desc();

    boolean notNull() default true;  //是否允许为null

    boolean notEmpty() default true;

    boolean digit() default false;

    int min() default -2147483648;

    int max() default 2147483647;

    String pattern() default "";

    int minSize() default -1;

    int maxSize() default -1;

    String length() default "";

    String in() default "";   //列表元素，使用,分割

    String laterTime() default "";

    int decimalLength() default -1;

    int integerLength() default -1;

    String dateFormat() default "";

}
