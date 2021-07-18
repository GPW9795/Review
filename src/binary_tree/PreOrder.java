package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        helper(list, node.left);
        helper(list, node.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
