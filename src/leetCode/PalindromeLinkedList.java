package leetCode;

import java.util.ArrayList;
import java.util.List;

import leetCode.model.ListNode;

/**
 * <pre>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * </pre>
 * 
 * @since Jan 12, 2022
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jan 12, 2022,AlexHsu,new
 *          </ul>
 */

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // head = [1,2,2,1]
        int[] head = { 1, 2, 2, 1 };
        boolean result = isPalindrome(ListNode.createListNodeByArray(head, 0));
        System.out.println(result);
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> linkedList = new ArrayList<>();
        int firstVal = head.val;
        ListNode temp = head;
        while (temp != null) {
            linkedList.add(temp.val);
            temp = temp.next;
        }
        int index = linkedList.size() - 1;
        boolean result = true;
        for (Integer val : linkedList) {
            if (val != linkedList.get(index)) {
                result = false;
            }
            index--;
        }
        return result;
    }
}
