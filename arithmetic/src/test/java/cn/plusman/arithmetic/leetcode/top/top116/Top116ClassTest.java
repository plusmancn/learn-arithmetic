package cn.plusman.arithmetic.leetcode.top.top116;

import cn.plusman.arithmetic.leetcode.top.Node;
import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/23 4:50 PM
 */
class Top116ClassTest {
    Top116Solution top116Solution = new Top116O1Class();
    
    @Test
    void connect() {
        Node result;
        
        result = top116Solution.connect(TreeNodeGenerator.fromListToNode(
            Arrays.asList(
                1,2,3,4,5,6,7
            )
        ));
        System.out.println(result);
    }
}