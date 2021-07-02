package cn.plusman.arithmetic.leetcode.top.top20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author plusman
 * @since 2021/7/2 4:02 PM
 */
public class Top20Class implements Top20Solution {
    private static final Map<Character, Character> bracketsMap = new HashMap<>();
    
    static {
        bracketsMap.put('(', ')');
        bracketsMap.put('[', ']');
        bracketsMap.put('{', '}');
    }
    
    @Override
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0) {
                char topCh = stack.peek();
                
                if (bracketsMap.get(topCh) == null) {
                    break;
                }
                
                if (bracketsMap.get(topCh) == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}
