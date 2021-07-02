package cn.plusman.arithmetic.leetcode.top.top17;

import java.util.*;

/**
 * @author plusman
 * @since 2021/7/2 12:56 PM
 */
public class Top17Class implements Top17Solution {
    private final static Map<Character, String> digitMap = new HashMap<>();
    static {
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }
    
    @Override
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        char curCh = digits.charAt(0);
        List<String> list = letterCombinations(digits.substring(1));
        List<String> newList = new ArrayList<>();
        int len = list.size();
        
        String alphabet = digitMap.get(curCh);
        for (int i = 0; i < alphabet.length(); i++) {
            if (len == 0) {
                newList.add(alphabet.substring(i, i+1));
            } else {
                for (int j = 0; j < len; j++) {
                    newList.add(
                        alphabet.substring(i, i+1).concat(list.get(j))
                    );
                }
            }
        }
        
        return newList;
    }
}
