package leetCode.model;

import java.util.LinkedList;
import java.util.List;

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

    public TreeNode creat(int[] arr) {
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
}
