package cn.plusman.arithmetic.leetcode.top.top13;

import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/1 9:58 AM
 */
public class Top13Class implements Top13Solution {
    private final static List<Character> romanPostion = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
    private final static List<Integer>  romanValue = Arrays.asList(1, 5, 10, 50, 100, 500, 1000);
    
    @Override
    public int romanToInt(String s) {
        int rtn = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch == 'I' || ch ==  'X' || ch == 'C') &&
                i + 1 < s.length()
            ) {
                char nextCh = s.charAt(i+1);
                int distance = romanPostion.indexOf(nextCh) - romanPostion.indexOf(ch);
                if(distance > 0 && distance < 3) {
                    int groupValue = romanValue.get(romanPostion.indexOf(nextCh)) - romanValue.get(romanPostion.indexOf(ch));
                    rtn += groupValue;
                    // peek two char once time.
                    i++;
                } else {
                    rtn += romanValue.get(romanPostion.indexOf(ch));
                }
            } else {
                rtn += romanValue.get(romanPostion.indexOf(ch));
            }
        }
        
        return rtn;
    }
}
