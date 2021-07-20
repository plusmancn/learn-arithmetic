package cn.plusman.arithmetic.leetcode.top.top3;

/**
 * @author plusman
 * @since 2021/6/6 3:27 PM
 */
public class Top3Class {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int Lcur = 1, Lmax = 1, head = 0, tail = 0;
        for (++tail; tail < chars.length; tail++) {
            for (int i = head; i < tail; i++) {
                if (chars[i] == chars[tail]) {
                    head = i + 1;
                    break;
                }
            }
            Lcur = tail - head + 1;
            if (Lcur > Lmax) {
                Lmax = Lcur;
            }
        }
        return Lmax;
    }
}
