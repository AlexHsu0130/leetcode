package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShuffleString {

    public static void main(String[] args) {
        String s = "vttqexwqgdc";
        int[] indices = { 9, 5, 8, 0, 4, 3, 6, 10, 1, 2, 7 };
        char[] arr = s.toCharArray();
        String[] sArry = s.split("");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < sArry.length; i++) {
            map.put(indices[i], sArry[i]);
        }
        Set<Integer> set = map.keySet();
        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);
        // List<String> valueSet = map.entrySet();
        List<String> resultList = new ArrayList<>();
        // for (Entry<String, String> entry : map.entrySet()) {
        // resultList.add(entry.getValue());
        // }
        StringBuffer sb = new StringBuffer();
        for (Integer key : setArr) {
            sb.append(map.get(key));
        }
        String result = String.join("", resultList);
        System.out.println(sb.toString());
    }

}
