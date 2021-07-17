package cn.plusman.learn.java.annotation;

/**
 * @author plusman
 * @since 2021/7/17 12:10 AM
 */
public class Sample {
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class) 
    public static void doublyBad() {
        
    }
}
