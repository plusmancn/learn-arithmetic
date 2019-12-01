package cn.plusman.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 前序遍历方案
public class DFSTraversal {
    public List<TreeNode> stackVersion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> rtn = new LinkedList<>();

        if(root != null) stack.push(root);

        while (!stack.empty()) {
            TreeNode element = stack.pop();
            rtn.add(element);

            if(element.right != null) stack.push(element.right);
            if(element.left != null) stack.push(element.left);
        }

        return rtn;
    }

    public void recursionVersion(TreeNode root) {
        if(root == null) return;

        System.out.print(root + " ");
        recursionVersion(root.left);
        recursionVersion(root.right);
    }
}
