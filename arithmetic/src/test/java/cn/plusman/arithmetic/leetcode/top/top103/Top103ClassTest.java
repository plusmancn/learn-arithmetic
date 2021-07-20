package cn.plusman.arithmetic.leetcode.top.top103;

import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/21 12:14 AM
 */
class Top103ClassTest {
    Top103Solution top103Solution = new Top103Class();
    
    @Test
    void zigzagLevelOrder() {
        List<List<Integer>> result;
    
        result = top103Solution.zigzagLevelOrder(TreeNodeGenerator.fromList(Arrays.asList(
            3,9,20,null,null,15,7
        )));
        System.out.println(result);
    }
}