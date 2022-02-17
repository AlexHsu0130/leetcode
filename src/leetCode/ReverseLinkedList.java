package leetCode;

import java.util.LinkedList;
import java.util.List;

import leetCode.model.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int node = 1;
        ListNode listNode = createListNode(node);
        System.out.println(reverseList(listNode));
        // for(int i = 0; i < node;i++) {
        // listNode = new ListNode();
        // }

    }

    private static ListNode createListNode(int node) {
        ListNode listNode = null;
        if (node < 6) {
            listNode = new ListNode(node, createListNode(++node));
        }
        return listNode;
    }

    // static List<ListNode> list = new LinkedList<>();

    public static ListNode reverseList(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListNode result = head;
        while (result != null) {
            linkedList.add(result.val);
            result = result.next;
        }
        result = head;
        while (linkedList.size() > 0) {
            result.val = linkedList.getLast();
            linkedList.removeLast();
            result = result.next;
        }

        List<ListNode> list = new LinkedList<>();
        reverseLinkedList(list, head);
        return list.size() > 0 ? list.get(0) : head;
    }

    // public static void addToLinkedList(ListNode head) {
    // if (head.next != null) {
    // addToLinkedList(head.next);
    // }
    // list.add(new ListNode(head.val, null));
    // }

    public static ListNode reverseLinkedList(List<ListNode> list, ListNode head) {
        ListNode temp = null;
        ListNode next = null;
        if (head != null && head.next != null) {
            temp = reverseLinkedList(list, head.next);
            next = new ListNode(head.val, null);
            temp.next = next;
            list.add(temp);
        }
        if (next == null) {
            next = head;
        }
        return next;
    }
}
