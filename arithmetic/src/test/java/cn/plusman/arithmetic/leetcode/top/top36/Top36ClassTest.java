package cn.plusman.arithmetic.leetcode.top.top36;

import com.sun.tools.internal.xjc.outline.Aspect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/4 11:45 AM
 */
class Top36ClassTest {
    Top36Solution top36Solution = new Top36Class();
    
    @Test
    void isValidSudoku() {
        boolean result;
        
        result = top36Solution.isValidSudoku(new char[][]{
            {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}}
        );
        Assertions.assertEquals(true, result);
    }
}