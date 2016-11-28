/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int flag = 0;
        ListNode head = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + flag;
            if (cur >= 10) {
                flag = 1;
                cur = cur % 10;
            } else {
                flag = 0;
            }
            ListNode curNode = new ListNode(cur);
            head.next = curNode;
            head = curNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int cur = l1.val + flag;
            if (cur >= 10) {
                flag = 1;
                cur = cur % 10;
            } else {
                flag = 0;
            }
            ListNode curNode = new ListNode(cur);
            head.next = curNode;
            head = curNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int cur = l2.val + flag;
            if (cur >= 10) {
                flag = 1;
                cur = cur % 10;
            } else {
                flag = 0;
            }
            ListNode curNode = new ListNode(cur);
            head.next = curNode;
            head = curNode;
            l2 = l2.next;
            
        }
        if (flag == 1) {
            ListNode curNode = new ListNode(1);
            head.next = curNode;
        }
        return dummy.next.next;
    }
}ß