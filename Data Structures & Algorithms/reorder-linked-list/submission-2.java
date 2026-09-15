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
        
        // finding mid point
        ListNode mid = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            mid = mid.next;
            fast = fast.next.next;
        }
        //breadking list into 2 lists at the midpoint
        ListNode head2 = mid.next;
        mid.next = null;
        
        //reversing second list;
        ListNode curr = head2;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //merging the two lists

        head2 = prev;
        ListNode curr1 = head;
        ListNode curr2 = head2;

        while (curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

    }
}
