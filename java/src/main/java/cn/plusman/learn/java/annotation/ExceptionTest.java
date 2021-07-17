package cn.plusman.learn.java.annotation;

import java.lang.annotation.*;

/**
 * @author plusman
 * @since 2021/7/16 11:59 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Exception> value();
}
