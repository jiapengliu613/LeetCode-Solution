/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        //first insert copy node into original list
        copyNode(head);
        
        //second copy random pointer 
        copyRandom(head);
        
        //finally split the new list;
        return splitList(head);
    }
    private void copyNode(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            newNode.random = head.random;
            head.next = newNode;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.next.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode current = dummy;
        while (head != null) {
            current.next = head.next;
            head.next = head.next.next;
            head = current.next.next;
            current = current.next;
        }
        return dummy.next;
    }
}