package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        List<Integer> lastArray = null;
        if (numRows > 0) {
            array.add(1);
            result.add(array);
        }
        for (int i = 1; i < numRows; i++) {
            array = new ArrayList<>(i + 1);
            lastArray = result.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) {
                    array.add(lastArray.get(j - 1) + lastArray.get(j));
                } else {
                    array.add(1);
                }
            }
            result.add(array);
        }
        return result;
    }

}
