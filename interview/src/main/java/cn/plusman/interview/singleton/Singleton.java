package cn.plusman.interview.singleton;

/**
 * cn.plusman.interview.singleton
 *
 * @author plusman
 * @since 12/27/20
 */

public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


