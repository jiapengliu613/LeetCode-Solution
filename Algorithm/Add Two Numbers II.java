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
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int val = 0;
        int carry = 0;
        Deque<ListNode> stack3 = new ArrayDeque<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            val = carry + stack1.pop().val + stack2.pop().val;
            carry = val / 10;
            ListNode current = new ListNode(val % 10);
            stack3.push(current);
        }
        while (!stack1.isEmpty()) {
            val = carry + stack1.pop().val;
            carry = val / 10;
            ListNode current = new ListNode(val % 10);
            stack3.push(current);
        }
        while (!stack2.isEmpty()) {
             val = carry + stack2.pop().val;
            carry = val / 10;
            ListNode current = new ListNode(val % 10);
            stack3.push(current);
        }
        if (carry == 1) {
            ListNode current = new ListNode(1);
            stack3.push(current);
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!stack3.isEmpty()) {
            current.next = stack3.pop();
            current = current.next;
        }
        return dummy.next;
    }
}