package leetCode;

import leetCode.model.TreeNode;

/**
 * <pre>
 * Given the root of a binary tree, return the length of the diameter of the tree.

 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 * The length of a path between two nodes is represented by the number of edges between them.
 * </pre>
 * 
 * @since Jan 16, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 16, 2022,AlexHsu,new
 *          </ul>
 */
public class DiameterOfBinaryTree {
    // 紀錄最長路徑
    public static int maxDistance = 0;

    public static void main(String[] args) {
    }

    /**
     * DFS_深度搜尋，進入數最後一個節點，往上一個節點就計算最大路徑並儲存與maxDistance比較上一個最長路徑。
     * 
     * @param root
     * @param step
     * @return
     */
    public static int maxDepthInDfs(TreeNode root, int lev) {
        if (root == null) {
            return lev;
        }
        int left = maxDepthInDfs(root.left, lev);
        int right = maxDepthInDfs(root.right, lev);
        maxDistance = Math.max(maxDistance, right + left);
        return Math.max(left, right) + 1;
    }
}
