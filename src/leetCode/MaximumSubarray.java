package leetCode;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray(arr);
    }

    public static int maxSubArray(int[] nums) {
        int tempVal = 0, maxVal = nums[0];
        for (int i = 0; i < nums.length; i++) {
            tempVal = nums[i];
            maxVal = tempVal > maxVal ? tempVal : maxVal;
            for (int j = i + 1; j < nums.length; j++) {
                tempVal = tempVal + nums[j];
                maxVal = tempVal > maxVal ? tempVal : maxVal;
            }
            tempVal = 0;
        }
        return maxVal;
    }

    public static int maxSubArray_bestSolution(int[] nums) {
        int prev = nums[0], max = prev;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + max, nums[i]);
            prev = Math.max(max, prev);
        }
        return prev;
    }
}
