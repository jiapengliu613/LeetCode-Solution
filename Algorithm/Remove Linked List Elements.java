/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode next = head.next;
        while (next != null) {
            while (next != null && next.val == val) {
                next = next.next;
            }
            head.next = next;
            head = next;
            if (next != null) {
                next = next.next;
            }
            
        }
        return dummy.next;
    }
}