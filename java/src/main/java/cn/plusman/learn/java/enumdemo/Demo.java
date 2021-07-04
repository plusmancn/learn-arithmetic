package cn.plusman.learn.java.enumdemo;

/**
 * @author plusman
 * @since 2021/7/3 9:49 AM
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(Planet.EARTH.publicStr);
        Planet.EARTH.publicStr = "白垩期";
        System.out.println(Planet.EARTH.publicStr);
        System.out.println(Planet.MERCURY);
        System.out.println(Planet.MERCURY.getXX());
    }
}
