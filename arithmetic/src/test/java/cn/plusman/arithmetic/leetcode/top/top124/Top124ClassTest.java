package cn.plusman.arithmetic.leetcode.top.top124;

import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/28 5:59 PM
 */
class Top124ClassTest {
    Top124Solution top124Solution = new Top124RecursiveClass();
    
    @Test
    void maxPathSum() {
        int result;
        
        // result = top124Solution.maxPathSum(TreeNodeGenerator.fromList(
        //     Arrays.asList(
        //         -10,9,20,null,null,15,7
        //     )
        // ));
        // Assertions.assertEquals(42, result);
    
    
        result = top124Solution.maxPathSum(TreeNodeGenerator.fromList(
            Arrays.asList(
                1,2,3
            )
        ));
        Assertions.assertEquals(6, result);
    }
}