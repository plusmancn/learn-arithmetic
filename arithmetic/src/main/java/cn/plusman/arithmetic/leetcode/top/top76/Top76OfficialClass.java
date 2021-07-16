package cn.plusman.arithmetic.leetcode.top.top76;

import java.util.*;

/**
 * @author plusman
 * @since 2021/7/16 11:39 AM
 */
public class Top76OfficialClass implements Top76Solution {
    @Override
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return ""; 
        }
        
        int mL = - 1;
        int mR = -1;
        int mW = Integer.MAX_VALUE;
    
        // quick search
        Map<Character, int[]> cap = new HashMap<>(26);
        int leftChart = t.length();
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            int[] curAndTarget = cap.computeIfAbsent(ch, k -> new int[]{0, 0});
            curAndTarget[1]++;
        }
        
        int l = 0, r = -1;
        while (true) {
            if(leftChart == 0) {
                Character ch = s.charAt(l);
    
                if (mW > r - l) {
                    mL = l;
                    mR = r;
                    mW = r - l;
                }
    
                int[] curAndTarget = cap.get(ch);
                if (curAndTarget != null) {
                    if (--curAndTarget[0] < curAndTarget[1]) {
                        leftChart++;
                    }
                }
                l++;
            } else {
                if (++r >= s.length()) {
                    break;
                }
                Character ch = s.charAt(r);
                
                int[] curAndTarget = cap.get(ch);
                if (curAndTarget != null) {
                    curAndTarget[0]++;
                    
                    if(curAndTarget[0] <= curAndTarget[1]) {
                        leftChart--;
                    }
                }
            }
        }
    
        if (mL == -1) {
            return "";
        } else  {
            return s.substring(mL, mR + 1);
        }
    }
}
