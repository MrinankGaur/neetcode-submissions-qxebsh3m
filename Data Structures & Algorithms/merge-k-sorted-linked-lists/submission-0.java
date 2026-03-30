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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0) return null;
        if(n==1) return lists[0];
        for(int i = 1;i<n;i++){
            lists[i] = merge2Lists(lists[i],lists[i-1]);
        }
        return lists[n-1];
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (l1!=null)?l1:l2;
        return head.next;

    }
}
