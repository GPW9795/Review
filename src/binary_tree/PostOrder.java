package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {
        if (node == null) return;
        helper(list, node.left);
        helper(list, node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return list;
    }
}
