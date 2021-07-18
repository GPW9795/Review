package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {
        if (node == null) return;
        helper(list, node.left);
        list.add(node.val);
        helper(list, node.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
