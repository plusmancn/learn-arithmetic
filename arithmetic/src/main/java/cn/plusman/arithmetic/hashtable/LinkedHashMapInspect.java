package cn.plusman.arithmetic.hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapInspect {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new LinkedHashMap<>();

        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(1, 13);

        for(Map.Entry e: m.entrySet()) {
            System.out.print(e.getKey() + " ");
        }


        HashMap<Integer, Integer> m2 = new LinkedHashMap<>(10, 0.75f, true);

        m2.put(3, 11);
        m2.put(1, 12);
        m2.put(5, 23);
        m2.put(2, 22);


        m2.put(3, 26);
        m2.get(5);
        System.out.println();
        for(Map.Entry e: m2.entrySet()) {
            System.out.print(e.getKey() + " ");
        }
    }
}
