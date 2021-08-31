package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 
 * <pre>
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 

You may assume that the majority element always exists in the array.
 * </pre>
 * 
 * @since Aug 31, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Aug 31, 2021,AlexHsu,new
 *          </ul>
 */
public class MajorityElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

        }
        Integer mainEle = null;
        Integer maxCount = null;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (mainEle == null && maxCount == null || entry.getValue() > maxCount) {
                mainEle = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mainEle;
    }

}
