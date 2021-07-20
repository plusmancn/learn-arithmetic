package cn.plusman.arithmetic.leetcode.top.top102;

import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/20 9:54 PM
 */
class Top102ClassTest {
    Top102Solution top102Solution = new Top102Class();
    
    @Test
    void levelOrder() {
        List<List<Integer>> result;
        
        result = top102Solution.levelOrder(TreeNodeGenerator.fromList(Arrays.asList(
            3,9,20,null,null,15,7
        )));
        System.out.println(result);
    
        result = top102Solution.levelOrder(TreeNodeGenerator.fromList(Arrays.asList(
            1
        )));
        System.out.println(result);
    
        result = top102Solution.levelOrder(TreeNodeGenerator.fromList(Arrays.asList()));
        System.out.println(result);
    }
}