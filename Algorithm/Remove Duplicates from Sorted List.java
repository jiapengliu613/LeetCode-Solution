/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, current = head.next;
        while (current != null) {
            while (current != null && current.val == prev.val) {
                current = current.next;
            }
            prev.next = current;
            prev = current;
            if (current != null) {
                current = current.next;
            }
        }
        return head;
    }
}