package leetCode;

/**
 * <pre>
Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.

Example 1:

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

Example 2:

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.
 * </pre>
 * 
 * @since Jan 18, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 18, 2021,AlexHsu,new
 *          </ul>
 */
public class CountGoodTriplets {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 0, 1, 1, 9, 7 };
        System.out.println(countGoodTriplets(arr, 7, 2, 3));

    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i = 0;
        for (int x = 0; x < arr.length - 2; x++) {
            for (int j = x + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[x] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[x] - arr[k]) <= c)) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }
}
