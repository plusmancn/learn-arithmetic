package cn.plusman.interview.ThreadStartTwice;

/**
 * cn.plusman.interview.ThreadStartTwice
 *
 * @author plusman
 * @since 12/28/20
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        new Error().printStackTrace();
    }
}
