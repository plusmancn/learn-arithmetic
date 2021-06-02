package cn.plusman.learn.java.generic;

import java.util.*;

/**
 * @author plusman
 * @since 2021/5/26 10:04 PM
 */
public class Sort {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ceg", "de", "a", "ddddg", "e");
        
        words.sort(Comparator.comparingInt(String::length));
        System.out.println(words);
        
        Map<String, Integer> map = new HashMap<>();
        map.put("Gina", 4);
        map.merge("July", 2, Integer::sum);
        map.merge("Gina", 2, Integer::sum);
        System.out.println(map);
    }
}
