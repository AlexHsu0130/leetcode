package leetCode;

import java.util.HashSet;
import java.util.Set;

import leetCode.model.ListNode;

/**
 * <pre>
 Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 If the two linked lists have no intersection at all, return null.
 
 解題有兩種解法。

使用Set：先歷遍 Linked List A，將每個Node的記憶體位置存到Set。
換歷遍Linked List B，並檢查B的Node的記憶體位置有無在Set，若有在Set，代表這Node為交會點；否則沒有交會點。
此方法需要額外Set的記憶體，但執行較快。

使用起點對齊的方式：
由於2個Linked List的長度可能不同，事先可以計算長度。假設Linked List A與Linked List B的長度分別為lenA與lenB。
lenA > lenB時，A先往前lenA - lenB步；否則B先往前lenB - lenA步
對齊後，代表這2個Linked List以同樣速度往前移動，代表能一起同時到結尾。
每次移動檢查記憶體位置是否相等，若有相等，則那位置是交會點。否則一起走到結尾null，代表沒交會點。

注意：這個交點是指定的，不是有相同的元素值就可以（比如ex1中的1），我們可以理解為當兩個連結串列指向同一個元素時即為相交 根據這種思路，
我們想到可以使用指標相等來判斷，分別遍歷兩個連結串列，當兩個指標相等時侯（即指向同一個位置或者同時為空）那麼就能證明兩個連結串列相交（不相交）。
 * </pre>
 * 
 * @since Aug 31, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Aug 31, 2021,AlexHsu,new
 *          </ul>
 */
public class IntersectionOfTwoLinkedLists {
    Set<ListNode> set = new HashSet<>();

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        addToSet(headA);
        return compareSet(headB);
    }

    public void addToSet(ListNode node) {
        if (node != null) {
            set.add(node);
            addToSet(node.next);
        }
    }

    public ListNode compareSet(ListNode node) {
        if (set.contains(node)) {
            return node;
        }
        if (node.next != null) {
            return compareSet(node.next);
        }
        return null;
    }

}
