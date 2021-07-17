package cn.plusman.arithmetic.leetcode.top.top79;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/17 5:41 PM
 */
class Top79ClassTest {
    Top79Solution top79Solution = new Top79Class();
    // Top79Solution top79Solution = new Top79OfficialClass();
    
    @Test
    void exist() {
        boolean result;
        
        result = top79Solution.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "ABCCED");
        Assertions.assertEquals(true, result);

        result = top79Solution.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "SEE");
        Assertions.assertEquals(true, result);

        result = top79Solution.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "ABCB");
        Assertions.assertEquals(false, result);


        result = top79Solution.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
        }, "ABCEFSADEESE");
        Assertions.assertEquals(true, result);

        result = top79Solution.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
        }, "ABCEFSADEESE");
        Assertions.assertEquals(true, result);
    
        result = top79Solution.exist(new char[][]{
            {'A', 'B', 'E'},
            {'B', 'C', 'D'}
        }, "ABCDEB");
        Assertions.assertEquals(true, result);
    }
}