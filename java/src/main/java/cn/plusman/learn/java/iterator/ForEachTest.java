package cn.plusman.learn.java.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/5 6:41 PM
 */
public class ForEachTest {
    public static void main(String[] args) {
        String[] fruits = new String[]{"apple", "banana"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    
        List<String> fruitList = Arrays.asList(fruits);
        for (String s : fruitList) {
            System.out.println(s);
        }
    }
}
