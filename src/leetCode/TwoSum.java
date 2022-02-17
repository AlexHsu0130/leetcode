package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        TwoSum.twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return nums;
    }

    //
    // TreeSet<Integer> ts = new TreeSet<>();
    // for (int i = 0; i < nums.length; i++) {
    // ts.add(nums[i]);
    // }
    // Iterator<Integer> it =ts.iterator();
    // List<Integer> list = new ArrayList<>();
    // Integer num = null;
    // while(it.hasNext()) {
    // num = it.next();
    // if(ts.contains(target - num)) {
    // list.add(num);
    // }
    // }
    // List<Integer> result = new ArrayList<>();
    // for(int i = 0; i < nums.length; i++) {
    // for(Integer integer: list) {
    // if(nums[i] == integer) {
    // result.add(i);
    // }
    // }
    // }
    // nums = new int[result.size()];
    // for(int i = 0; i < result.size(); i++) {
    // nums[i] = result.get(i);
    // }
    // return nums;

}
