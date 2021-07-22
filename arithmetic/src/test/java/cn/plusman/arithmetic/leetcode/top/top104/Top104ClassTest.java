package cn.plusman.arithmetic.leetcode.top.top104;

import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/21 11:59 AM
 */
class Top104ClassTest {
    Top104Solution top104Solution = new Top104DFSClass();
    
    @Test
    void maxDepth() {
        int result;
    
        result = top104Solution.maxDepth(TreeNodeGenerator.fromList(Arrays.asList(
            3,9,20,null,null,15,7
        )));
        Assertions.assertEquals(3, result);
    }
}