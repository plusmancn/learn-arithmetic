package cn.plusman.learn.java.lambda;

/**
 * @author plusman
 * @since 2021/4/5 5:09 PM
 */
@FunctionalInterface
public interface Foo {
    
    String method(String string);
    
    default void defaultMethod() {
    }
}
