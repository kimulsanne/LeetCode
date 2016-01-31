//LeetCode#19: Remove Nth Node From End of List
//Runtiome: 1ms
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode result = head;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 1)
            return null;
        if (list.size() == n)
            return result.next;
        list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
        return result;
    }
}