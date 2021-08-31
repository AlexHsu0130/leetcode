package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetCode.model.TreeNode;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

}
