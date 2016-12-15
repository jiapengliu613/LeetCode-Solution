/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
            });
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                pq.add(node);
            
        while (!pq.isEmpty()) {
            ListNode tmpMin = pq.poll();
            current.next = tmpMin;
            current = current.next;
            
            if (tmpMin.next != null)
                pq.add(tmpMin.next);
        }
        return dummy.next;
        
        
        
        
        
        
        
        /* TLE O(n * k) solution
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode next = null;
        do {
            next = findSmallest(lists);
            current.next = next;
            current = next;
        } while (next != null);
        return dummy.next;
        
    }
    private ListNode findSmallest(ListNode[] lists) {
        int minVal = Integer.MAX_VALUE;
        ListNode minNode = null;
        int idx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minVal) {
                minVal = lists[i].val;
                minNode = lists[i];
                idx = i;
            }
        }
        if (idx != -1)
            lists[idx] = lists[idx].next;
        return minNode;
        */
        
    }
}