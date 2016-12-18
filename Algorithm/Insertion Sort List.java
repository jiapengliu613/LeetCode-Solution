/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean flag = false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        do {
            head = dummy.next;
            flag = false;
            while (head.next != null) {
                if (head.next.val < head.val) {
                    break;
                }
                
                head = head.next;
            }
            //System.out.println(head.val);
            if (head.next != null) {
                ListNode target = head.next;
                //System.out.println(target);
                head.next = target.next;
                ListNode slow = dummy;
                ListNode fast = dummy.next;
                while (fast != null) {
                    if (fast.val > target.val) {
                        break;
                    }
                    slow = fast;
                    fast = fast.next;
                }
                target.next = fast;
                slow.next = target;
                flag = true;
            }
        } while (flag);
        return dummy.next;
    }
}