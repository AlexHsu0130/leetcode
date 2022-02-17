package leetCode;

public class MergeSortedArray {

    public static void main(String[] args) {
        // int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        // int m = 3;
        // int[] nums2 = new int[] { 2, 5, 6 };
        // int n = 3;
        int[] nums1 = new int[] { 2, 0 };
        int m = 1;
        int[] nums2 = new int[] { 1 };
        int n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two Pointer Approach
        int p1 = m - 1, p2 = n - 1, i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
    }
}
