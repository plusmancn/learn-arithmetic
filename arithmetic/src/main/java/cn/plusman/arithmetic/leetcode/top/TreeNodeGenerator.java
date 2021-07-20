package cn.plusman.arithmetic.leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generate LeetCode treeNode from List
 * @author plusman
 * @since 2021/7/19 9:14 AM
 */
public class TreeNodeGenerator {
    public static TreeNode fromList(List<Integer> arr) {
        if (arr.isEmpty()) {
            return null;
        }
        
        TreeNode root = null;
        
        Map<Integer, List<TreeNode>> horizontal = new HashMap<>();
     
        int count = 0;
        for (int i = 0;; i++) {
            double capacity = Math.pow(2, i);
            List<TreeNode> line = horizontal.computeIfAbsent(i, (k) -> new ArrayList<>());
                
            for (int j = 0; j < capacity; j++) {
                TreeNode treeNode = null;
                Integer value;
                if ((value = arr.get(count++)) != null) {
                    treeNode = new TreeNode();
                    treeNode.val = value;
                }
                
                if (i == 0) {
                    root = treeNode;
                    line.add(treeNode);
                } else {
                    TreeNode parent = horizontal.get(i - 1).get(j / 2);
                    if (j % 2 == 0) {
                        parent.left = treeNode;
                    } else {
                        parent.right = treeNode;
                    }
                    
                    if (treeNode != null) {
                        line.add(treeNode);
                    }
                }
                
                if (count >= arr.size()) {
                    return root;
                }
            }
        }
    }
}
