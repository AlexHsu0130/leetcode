package leetCode;

/**
 * <pre>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * </pre>
 * 
 * @since Jan 12, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 12, 2022,AlexHsu,new
 *          </ul>
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int e : nums) {
            if (target > e) {
                index++;
            } else if (target < e) {
                break;
            }
        }
        return index;
    }

}
