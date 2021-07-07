package cn.plusman.learn.java.override;

import java.math.BigInteger;
import java.util.*;

/**
 * @author plusman
 * @since 2021/7/7 12:02 PM
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }
    
    public static String classify(List<?> lst) {
        return "List";
    }
    
    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }
    
    public static void main(String[] args) {
        Collection<?>[] collections = {
            new HashSet<>(),
            new ArrayList<BigInteger>(),
            new HashMap<String, String>().values()
        };
        
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
