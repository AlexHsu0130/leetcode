package leetCode;

import leetCode.model.TreeNode;

/**
 * <pre>
 * Given the root of a binary tree, invert the tree, and return its root.
 * </pre>
 * 
 * @since Jan 12, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 12, 2022,AlexHsu,new
 *          </ul>
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        // root = [4,2,7,1,3,6,9]
        // Output: [4,7,2,9,6,3,1]
        int[] arr = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode node = invertBinaryTree(TreeNode.creatByArray(arr));
        System.out.println(TreeNode.maxDepthInBfs(node));

    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.right != null) {
            invertBinaryTree(root.right);
        }
        if (root.left != null) {
            invertBinaryTree(root.left);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
