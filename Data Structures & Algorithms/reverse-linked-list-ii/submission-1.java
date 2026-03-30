class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode start = head;
        ListNode end = head;
        ListNode prev = null;

        for (int i = 1; i < left; i++) {
            prev = start;
            start = start.next;
        }
        end = start;
        for (int i = left; i < right; i++) {
            end = end.next;
        }

        ListNode next = end.next;

        if (prev != null) prev.next = null;
        end.next = null;

        // reverse
        ListNode curr = start;
        ListNode prev1 = null;

        while (curr != null) {
            ListNode nex = curr.next;
            curr.next = prev1;
            prev1 = curr;
            curr = nex;
        }

        // reconnect
        if (prev != null) {
            prev.next = prev1;
        } else {
            head = prev1;
        }

        start.next = next;

        return head;
    }
}