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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;
        ListNode curr = new ListNode(-1);
        while(l1!=null && l2!=null){
            int sum = carry + l1.val + l2.val;
            int digit = sum%10;
            carry = sum/10;
            l1.val = digit;
            curr =l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                int sum = carry + l1.val;
                int digit = sum%10;
                carry = sum/10;
                curr =l1;
                l1.val = digit;
                l1 = l1.next;
            } 
        }
        if(l2!=null){
            while(l2!=null){
                int sum = carry + l2.val;
                int digit = sum%10;
                carry = sum/10;
                curr.next = new ListNode(digit);
                curr = curr.next;
                l2 = l2.next;
            } 
        }
        if(carry>0) curr.next = new ListNode(carry);

        return head;
        
    }
}
