package leetCode;

import java.util.LinkedList;
import java.util.Queue;

import leetCode.model.TreeNode;

/**
 * <pre>
 Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * </pre>
 * 
 * @since Jul 14, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jul 14, 2021,AlexHsu,new
 *          </ul>
 */
public class MaximumDepthOfBinaryTree {
    static long endTime = 0;

    public static void main(String[] args) {
        int[] testData = new int[800000];
        for (int i = 0; i < testData.length; i++) {
            testData[i] = i + 1;
        }
        TreeNode tr = new TreeNode();
        TreeNode btree = tr.creat(testData);
        System.out.println("DFS START");
        long startTime = System.currentTimeMillis(); // 獲取開始時間
        System.out.println("DFS RESULT : " + maxDepthInDfs(btree, 0) + "'s STEP");
        System.out.println("DFS TAKE TIME : " + (endTime - startTime) + "ms");
        System.out.println("BFS START");
        startTime = System.currentTimeMillis(); // 獲取開始時間
        System.out.println("BFS RESULT : " + maxDepthInBfs(btree) + "'s STEP");
        System.out.println("BFS TAKE TIME : " + (endTime - startTime) + "ms");
    }

    /**
     * DFS_深度搜尋
     * 
     * @param root
     * @param step
     * @return
     */
    public static int maxDepthInDfs(TreeNode root, int step) {
        if (root == null) {
            return step;
        }
        int left = maxDepthInDfs(root.left, step + 1);
        int right = maxDepthInDfs(root.right, step + 1);
        endTime = System.currentTimeMillis(); // 獲取結束時間
        return left > right ? left : right;
    }

    /**
     * BFS_廣度搜尋
     * 
     * @param root
     * @return
     */
    public static int maxDepthInBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = null;
        queue.offer(root);
        int stept = 0;
        while (queue.size() > 0 && root != null) {
            queueTemp = new LinkedList<>();
            while (queue.size() > 0) {
                root = queue.poll();
                if (root != null) {
                    if (root.left != null) {
                        queueTemp.offer(root.left);
                    }
                    if (root.right != null) {
                        queueTemp.offer(root.right);
                    }
                }
            }
            queue = queueTemp;
            stept++;
        }
        endTime = System.currentTimeMillis(); // 獲取結束時間
        return stept;
    }

}
