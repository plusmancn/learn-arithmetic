package cn.plusman.arithmetic.leetcode.top.top49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author plusman
 * @since 2021/7/6 5:38 PM
 */
public class Top49Class implements Top49Solution {
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String key = simpleHash(strs[i]);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(strs[i]);
        }
        
        return map.values().stream().collect(Collectors.toList());
    }
    
    private String simpleHash(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                sb.append((char) (i + 'a'));
            }
            if (hash[i] > 1) {
                sb.append(hash[i]);
            }
        }
        return sb.toString();
    }
}
