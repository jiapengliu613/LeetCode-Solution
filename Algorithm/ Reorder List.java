/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = reverseList(mid);
        //System.out.println("" + head.val + " " + newHead.val + " " + newHead.next.val);
        while (head != null && newHead != null) {
            ListNode next = head.next;
            ListNode newNext = newHead.next;
            head.next = newHead;
            newHead.next = next;
            head = next;
            newHead = newNext;
        }
        
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}