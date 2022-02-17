package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * <pre>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * </pre>
 * 
 * @since Jan 13, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 13, 2022,AlexHsu,new
 *          </ul>
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        // FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        FindAllNumbersDisappearedInAnArray.findDisappearedNumbers2(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean getLost = false;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (i == nums[k]) {
                    getLost = true;
                }
            }
            if (!getLost) {
                list.add(i);
            }
            getLost = false;
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            ts.add(nums[i]);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!ts.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

}
