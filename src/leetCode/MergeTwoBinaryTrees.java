package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetCode.model.TreeNode;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;

        }
        if (t2 == null) {
            return t1;

        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static List<TreeNode> mergeTreeList(TreeNode root1, TreeNode root2) {
        List<TreeNode> tree1 = maxDepthInBfs(root1);
        List<TreeNode> tree2 = maxDepthInBfs(root2);
        List<TreeNode> result = new ArrayList<>();
        TreeNode tree1Temp = null;
        TreeNode tree2Temp = null;
        TreeNode mergeTree = null;
        int tree1Size = tree1.size();
        int tree2Size = tree2.size();
        int len = tree1Size > tree2Size ? tree1Size : tree2Size;
        for (int i = 0; i < len; i++) {
            tree1Temp = tree1Size > i ? tree1.get(i) : null;
            tree2Temp = tree2Size > i ? tree2.get(i) : null;
            if (tree1Temp == null && tree2Temp == null) {
                result.add(null);
                continue;
            } else if (tree1Temp != null && tree2Temp == null) {
                tree1Temp.left = null;
                tree1Temp.right = null;
                result.add(tree1Temp);
            } else if (tree1Temp == null && tree2Temp != null) {
                tree2Temp.left = null;
                tree2Temp.right = null;
                result.add(tree2Temp);
            } else {
                mergeTree = new TreeNode();
                mergeTree.val = tree1Temp.val + tree2Temp.val;
                result.add(mergeTree);
            }

        }
        return result;
    }

    /**
     * BFS_廣度搜尋
     * 
     * @param root
     * @return
     */
    public static List<TreeNode> maxDepthInBfs(TreeNode root) {
        List<TreeNode> treeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = null;
        queue.offer(root);
        treeList.add(root);
        while (queue.size() > 0 && root != null) {
            queueTemp = new LinkedList<>();
            while (queue.size() > 0) {
                root = queue.poll();
                if (root != null) {
                    // if (root.left != null) {
                    queueTemp.offer(root.left);
                    // }
                    // if (root.right != null) {
                    queueTemp.offer(root.right);
                    // }
                } else {
                    queueTemp.offer(null);
                    queueTemp.offer(null);
                }
            }
            treeList.addAll(queueTemp);
            queue = queueTemp;
        }
        return treeList;
    }

    public static TreeNode creatByArray(List<TreeNode> linkNod) {
        if (linkNod.isEmpty()) {
            return new TreeNode();
        }
        TreeNode root = null;
        TreeNode result = root;
        int treeIndex = 0;
        int childLfIndex = 0;
        int childRhIndex = 0;

        for (int i = 0; i < linkNod.size(); i++) {
            root = linkNod.get(i);
            // 二元樹的位置
            treeIndex = i + 1;
            // treeIndex * 2為樹左節點index
            // 樹左子節點index與陣列index差1，故childLfIndex為陣列index
            childLfIndex = treeIndex * 2 - 1;
            // 右子節點
            // treeIndex * 2 + 1為樹右節點index，childLfIndex為陣列index
            childRhIndex = treeIndex * 2;
            if (linkNod.size() > childLfIndex && linkNod.get(i) != null) {
                root.left = linkNod.get(childLfIndex);
            }
            if (linkNod.size() > childRhIndex && linkNod.get(i) != null) {
                root.right = linkNod.get(childRhIndex);
            }
        }
        return result;
    }

}
