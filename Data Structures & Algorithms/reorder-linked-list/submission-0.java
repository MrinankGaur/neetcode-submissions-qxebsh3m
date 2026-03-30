/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merge two halves
        ListNode l1 = head;
        ListNode l2 = prev;

        while(l2 != null){
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;

            l1.next = l2;
            l2.next = t1;

            l1 = t1;
            l2 = t2;
        }
    }
}

