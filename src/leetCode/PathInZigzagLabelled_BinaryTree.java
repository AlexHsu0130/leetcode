package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since Jan 12, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 12, 2021,AlexHsu,new
 *          </ul>
 */
public class PathInZigzagLabelled_BinaryTree {

    public static void main(String[] args) {
        List<Integer> i = pathInZigZagTree(14);
        i.forEach(x -> System.out.println(x));
    }

    /*
     * 每一層的定位與2的n次方有關，每一層與上一層的關聯為分組及位置，需考慮到數字逆轉問題。
     */
    public static List<Integer> pathInZigZagTree(int label) {
        Double dul = Math.log(label) / Math.log(2);
        // 找出哪一層
        int lavel = dul.intValue();
        // 找出lavel最小數字
        Double fristNum = Math.pow(2, lavel);
        List<Integer> list = new ArrayList<>();
        list.add(label);
        int group = 0;
        // 找到自己目前的數字是屬於哪一組
        int groupSelf = 0;
        // 上一個數字
        int preNum = 0;
        // lavel往回抓
        while (lavel > 0) {
            // true 代表上一層為偶數層需要逆轉
            // revers = lavel % 2 != 0;
            fristNum = Math.pow(2, lavel);
            // 總共有幾組
            group = fristNum.intValue() / 2;
            // 自己的分組將是上一顆球的位置，在偶數次方位時自己的分組也須逆轉
            if (lavel % 2 != 0) {
                // 自己的分組將是上一顆球的位置，在偶數次方位時自己的分組也須逆轉
                groupSelf = (int) (label - fristNum.intValue()) / 2 + 1;
                // prePosition = group - (label - fristNum.intValue()) / 2;
                // preNum = (上一層最大數字-現在這一層分組＋1)
                // 找到偶數層最後一個數字為倒轉故從最大數字往前抓
                // preNum = (((int) Math.pow(2, lavel - 1)) * 2 - 1) - groupSelf + 1;
                preNum = ((int) Math.pow(2, lavel - 1)) * 2 - groupSelf;
            } else {
                // 自己的分組將是上一顆球的位置
                groupSelf = group - (int) ((label - fristNum.intValue()) / 2);
                // preNum = 上一層最小數字＋本層分組 - 1
                preNum = (int) Math.pow(2, lavel - 1) + groupSelf - 1;
            }
            label = preNum;
            list.add(preNum);
            lavel--;
        }
        Collections.reverse(list);
        return list;
    }
}
