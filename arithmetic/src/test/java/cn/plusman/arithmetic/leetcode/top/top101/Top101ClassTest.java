package cn.plusman.arithmetic.leetcode.top.top101;

import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/20 9:46 AM
 */
class Top101ClassTest {
    Top101Solution top101Solution = new Top101RecursiveClass();
    
    @Test
    void isSymmetric() {
        boolean result;
    
        result = top101Solution.isSymmetric(TreeNodeGenerator.fromList(Arrays.asList(
            1,2,2,3,4,4,3
        )));
        Assertions.assertEquals(true, result);

        result = top101Solution.isSymmetric(TreeNodeGenerator.fromList(Arrays.asList(
            1,2,2,null,3,null,3
        )));
        Assertions.assertEquals(false, result);

        result = top101Solution.isSymmetric(TreeNodeGenerator.fromList(Arrays.asList(
            0
        )));
        Assertions.assertEquals(true, result);

        result = top101Solution.isSymmetric(TreeNodeGenerator.fromList(Arrays.asList(
            1,2,2,2,null,2
        )));
        Assertions.assertEquals(false, result);
    
        result = top101Solution.isSymmetric(TreeNodeGenerator.fromList(Arrays.asList(
            1,null,2
        )));
        Assertions.assertEquals(false, result);
    }
}