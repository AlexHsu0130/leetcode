package leetCode;

/**
 * <pre>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * </pre>
 * 
 * @since Jan 13, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 13, 2022,AlexHsu,new
 *          </ul>
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        int[] nums1 = { 0, 0, 1 };
        int[] nums2 = { 1, 0 };
        int[] nums3 = { 1, 0, 1 };
        // MoveZeroes.moveZeroes(nums1);
        MoveZeroes.moveZeroes2(nums3);
    }

    public static int[] moveZeroes(int[] nums) {
        int zeroes = 0;
        int range = nums.length;
        for (int i = 0; i < range;) {
            if (nums[i] == 0 && i < range) {
                zeroes++;
                for (int k = i + 1; k < nums.length; k++) {
                    nums[k - 1] = nums[k];
                }
                i = 0;
                range = nums.length - zeroes;
                nums[range] = 0;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static int[] moveZeroes2(int[] nums) {
        int countZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i - countZeros] = nums[i];
            } else {
                countZeros++;
            }
        }
        for (int i = nums.length - 1; i > nums.length - countZeros - 1; i--) {
            nums[i] = 0;
        }
        return nums;
    }
}
