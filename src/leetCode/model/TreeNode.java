package leetCode.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode creatByArray(int[] arr) {
        TreeNode temp = null;
        List<TreeNode> linkNod = new LinkedList<>();
        for (int z = 0; z < arr.length; z++) {
            if (arr[z] != 0) {
                temp = new TreeNode();
                temp.val = arr[z];
                linkNod.add(temp);
            } else {
                linkNod.add(new TreeNode());
            }
        }

        for (int i = 0; i < linkNod.size(); i++) {

            int treeIndex = i + 1;
            int childLfIndex = (treeIndex * 2) - 1;
            int childRhIndex = treeIndex * 2;
            if (linkNod.size() > childLfIndex) {
                linkNod.get(i).left = linkNod.get(childLfIndex);
            }
            if (linkNod.size() > childRhIndex) {
                linkNod.get(i).right = linkNod.get(childRhIndex);
            }

        }
        return linkNod.get(0);
    }

    public static TreeNode creatByArray(Integer[] arr) {
        TreeNode temp = null;
        List<TreeNode> linkNod = new ArrayList<>();
        for (int z = 0; z < arr.length; z++) {
            if (arr[z] != null) {
                temp = new TreeNode();
                temp.val = arr[z];
                linkNod.add(temp);
            } else {
                linkNod.add(null);
            }
        }

        for (int i = 0; i < linkNod.size(); i++) {

            int treeIndex = i + 1;
            int childLfIndex = (treeIndex * 2) - 1;
            int childRhIndex = treeIndex * 2;
            if (linkNod.size() > childLfIndex && linkNod.get(i) != null) {
                linkNod.get(i).left = linkNod.get(childLfIndex);
            }
            if (linkNod.size() > childRhIndex && linkNod.get(i) != null) {
                linkNod.get(i).right = linkNod.get(childRhIndex);
            }

        }
        return linkNod.get(0);
    }

    public static TreeNode creatByArray(List<TreeNode> linkNod) {
        if (linkNod.isEmpty()) {
            return new TreeNode();
        }
        TreeNode root = linkNod.get(0);
        TreeNode result = root;
        int treeIndex = 0;
        int childLfIndex = 0;
        int childRhIndex = 0;

        for (int i = 0; i < linkNod.size(); i++) {
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
            root = linkNod.get(i + 1);
        }
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        /*
         * Recursively construct the left subtree and make it left child of root
         */
        node.left = sortedArrayToBST(nums, start, mid - 1);

        /*
         * Recursively construct the right subtree and make it right child of root
         */
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }

    /**
     * BFS_廣度搜尋
     * 
     * @param root
     * @return
     */
    public static List<Integer> maxDepthInBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = null;
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (queue.size() > 0 && root != null) {
            queueTemp = new LinkedList<>();
            while (queue.size() > 0) {
                root = queue.poll();
                result.add(root.val);
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
        }

        return result;
    }

    public static Map<Integer, TreeNode> mergeTreeMap(TreeNode root1, TreeNode root2) {
        Map<Integer, TreeNode> tree1 = convert2Map(root1);
        Map<Integer, TreeNode> tree2 = convert2Map(root2);
        TreeNode tree1Temp = null;
        TreeNode tree2Temp = null;
        for (Map.Entry<Integer, TreeNode> entry : tree1.entrySet()) {
            tree1Temp = entry.getValue();
            tree2Temp = tree2.get(entry.getKey());
            if (tree2Temp != null) {
                tree1Temp.val = tree1Temp.val + tree2Temp.val;
                tree1.put(tree1Temp.val, tree1Temp);
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : tree2.entrySet()) {
            tree1Temp = tree1.get(entry.getKey());
            if (tree1Temp == null) {
                tree1.put(entry.getKey(), entry.getValue());
            }

        }

        return tree1;
    }

    public static Map<Integer, TreeNode> convert2Map(TreeNode root) {
        Map<Integer, TreeNode> treeMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = null;
        int treeIdx = 1;
        queue.offer(root);
        treeMap.put(treeIdx, root);
        while (queue.size() > 0 && root != null) {
            queueTemp = new LinkedList<>();
            while (queue.size() > 0) {
                root = queue.poll();
                if (root != null) {
                    queueTemp.offer(root.left);
                    if (root.left != null) {
                        treeMap.put(++treeIdx, root.left);
                    } else {
                        treeIdx++;
                    }
                    queueTemp.offer(root.right);
                    if (root.right != null) {
                        treeMap.put(++treeIdx, root.right);
                    } else {
                        treeIdx++;
                    }
                } else {
                    treeIdx = treeIdx + 2;
                }
            }
            queue = queueTemp;
        }
        return treeMap;
    }

    public static TreeNode creatByMap(Map<Integer, TreeNode> treeMap) {
        if (treeMap.isEmpty()) {
            return new TreeNode();
        }
        TreeNode root = treeMap.get(1);
        TreeNode result = root;
        int treeIndex = 0;
        int childLfIndex = 0;
        int childRhIndex = 0;

        for (Map.Entry<Integer, TreeNode> entry : treeMap.entrySet()) {
            treeIndex = entry.getKey();
            root = entry.getValue();
            childLfIndex = treeIndex * 2;
            childRhIndex = treeIndex * 2 + 1;
            root.left = treeMap.get(childLfIndex);
            root.right = treeMap.get(childRhIndex);
        }
        return result;
    }
}
