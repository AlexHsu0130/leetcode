package leetCode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNodeByIncrement(int nodeVal, int length) {
        ListNode listNode = null;
        if (nodeVal < length) {
            listNode = new ListNode(nodeVal, createListNodeByIncrement(++nodeVal, length));
        }
        return listNode;
    }

    public static ListNode createListNodeByArray(int[] nodeVal, int index) {
        ListNode root = new ListNode();
        ListNode listNode = root;
        while (index < nodeVal.length) {
            listNode.val = nodeVal[index];
            listNode.next = new ListNode();
            listNode = listNode.next;
            index++;
        }
        return listNode;
    }
}
