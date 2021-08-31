package leetCode;

import java.util.HashSet;
import java.util.Set;

import leetCode.model.ListNode;

/**
 * <pre>
 Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 * </pre>
 * 
 * @since Aug 30, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Aug 30, 2021,AlexHsu,new
 *          </ul>
 */
public class LinkedListCycle {

    static Set<ListNode> linkSet = new HashSet<>();

    public static void main(String[] args) {

    }

    ListNode slow = null;
    ListNode fast = null;

    public boolean hasCycleTemp(ListNode head) {
        if (head == null) {
            return false;
        }
        slow = head.next;
        if (slow == null) {
            return false;
        }
        if (slow.next == null) {
            return false;
        }
        if (slow.next.next == null) {
            return false;
        }
        fast = slow.next.next;
        if (head == fast) {
            return true;
        }
        if (slow == fast) {
            return true;
        }
        return hasCycle(slow);
    }

    public static boolean hasCycle(ListNode head) {

        ListNode temp = head;
        while (temp.next != null) {
            if (temp == head) {
                return true;
            }
            temp = head.next;
        }

        if (temp.next == null) {
            return false;
        }

        return hasCycle(head.next);
    }

    public static boolean hasCycleBySet(ListNode head) {
        if (head == null) {
            return false;
        }
        linkSet.add(head);
        if (linkSet.contains(head.next)) {
            return true;
        }
        return hasCycle(head.next);
    }
}
