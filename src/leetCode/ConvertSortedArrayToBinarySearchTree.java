package leetCode;

import leetCode.model.TreeNode;

/**
 * <pre>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * </pre>
 * 
 * @since Aug 30, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Aug 30, 2021,AlexHsu,new
 *          </ul>
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

        int[] nums = new int[] { -10, -3, 0, 5, 9 };
        TreeNode tr = new TreeNode();
        tr = tr.sortedArrayToBST(nums, 0, nums.length);
    }
}
