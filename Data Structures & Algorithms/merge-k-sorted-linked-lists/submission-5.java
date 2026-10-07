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
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);

    }
    public ListNode divide(ListNode[] lists, int l, int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return lists[l];
        }
        int mid = l + (r-l)/2;
        ListNode left = divide(lists,l,mid);
        ListNode right = divide(lists,mid+1,r);
        return merge2Lists(left,right);
    }
    public ListNode merge2Lists(ListNode head1, ListNode head2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                temp.next = head1;
                
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!=null){
            temp.next = head1;
        }
        if(head2!=null){
            temp.next = head2;
        }
        return head.next;
    }
}
