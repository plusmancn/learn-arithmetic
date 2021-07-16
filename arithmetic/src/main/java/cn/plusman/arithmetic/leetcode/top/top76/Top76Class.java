package cn.plusman.arithmetic.leetcode.top.top76;

import java.util.*;

/**
 * Too complex to understand and debug
 * @author plusman
 * @since 2021/7/15 10:57 PM
 */
@Deprecated
public class Top76Class implements Top76Solution {
    @Override
    public String minWindow(String s, String t) {
        int mL = -1, mR = -1;
        int mW = Integer.MAX_VALUE;
        
        // window position
        List<Character> windowOrdered = new ArrayList<>();
        List<Character> tChars = new ArrayList<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            tChars.add(t.charAt(i));
        }
        
        int l = -1, r = -1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            
            if (tChars.isEmpty()) {
                if (mW > r - l) {
                    mL = l;
                    mR = r;
                    mW = r - l;
                }
                
                int pos;
                if ((pos = windowOrdered.indexOf(ch)) != -1) {
                    if (pos + 1 < windowOrdered.size()) {
                        l = s.indexOf(windowOrdered.get(pos + 1), l);
                        
                        int finalL = l;
                        int countEdge = (int) windowOrdered.stream().filter(v -> v == s.charAt(finalL)).count();
                        
                        
                    } else {
                        l = i;
                    }
                    r = i;
    
                    List<Character> slideParts = windowOrdered.subList(0, pos);
                    tChars.addAll(slideParts);
                    windowOrdered = windowOrdered.subList(pos + 1, windowOrdered.size());
                    windowOrdered.add(ch);
                }
            } else {
                if (tChars.remove(ch)) {
                    windowOrdered.add(ch); 
                    l = l == -1 ? i : l;
                    r = i;
                } else if (windowOrdered.indexOf(ch) !=-1 && s.charAt(l) == ch) {
                    l++;
                }
            }
        }
    
        if (tChars.isEmpty()) {
            if (mW > r - l) {
                mL = l;
                mR = r;
                mW = r - l;
            }
        }
        
        if (mL == -1) {
            return "";
        } else  {
            return s.substring(mL, mR + 1);
        }
    }
}
