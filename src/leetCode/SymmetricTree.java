package leetCode;

import java.util.LinkedList;
import java.util.Queue;

import leetCode.model.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        int[] testData = new int[] { 2, 3, 3, 4, 5, 5, 4, 0, 0, 8, 9, 9, 8 };
        int[] testData2 = new int[] { 1, 2, 2, 2, 0, 2 };
        int[] testData3 = new int[] { 5, 4, 1, 0, 1, 0, 4, 2, 0, 2, 0 };
        int[] testData4 = new int[] { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode tr = new TreeNode();
        TreeNode btree = tr.creat(testData4);
        System.out.println(isSymmetric(btree));
    }

    public static boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
        // return iterative(root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    // Approach 2: Iterative
    // Instead of recursion, we can also use iteration with the aid of a queue. Each two consecutive nodes in the queue should be equal, and their subtrees a mirror of each other. Initially, the queue
    // contains root and root. Then the algorithm works similarly to BFS, with some key differences. Each time, two nodes are extracted and their values compared. Then, the right and left children of
    // the two nodes are inserted in the queue in opposite order. The algorithm is done when either the queue is empty, or we detect that the tree is not symmetric (i.e. we pull out two consecutive
    // nodes from the queue that are unequal).
    public static boolean iterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
