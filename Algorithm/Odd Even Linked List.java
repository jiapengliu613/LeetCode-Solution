/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummyOdd = new ListNode(0);
        dummyOdd.next = head;
        ListNode dummyEven = new ListNode(0);
        dummyEven.next = head.next;
        while (odd != null && even != null) {
            odd.next = even.next;
            odd = odd.next;
            if (odd != null) {
                even.next = odd.next;
                even = even.next;
            }
            //head = odd;
            //System.out.println(" " + odd.val + " " + even.val);
        }
        //odd.next = dummyEven.next;
        ListNode tail = dummyOdd.next;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = dummyEven.next;
        return dummyOdd.next;
    }
}