package cn.plusman.arithmetic.leetcode.top.top130;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/18 11:21 PM
 */
class Top130ClassTest {
    Top130Solution top130Solution = new Top130Class();
    
    @Test
    void solve() {
        char[][] input = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        
        top130Solution.solve(input);
        InspectUtil.showArray(input);
    }
}