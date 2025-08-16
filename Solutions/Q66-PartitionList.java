class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevTail = dummy; // end of "< x" partition
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            ListNode then = curr.next;
            if (curr.val < x) {
                if (prev != prevTail) {
                    
                    prev.next = curr.next;
                    curr.next = prevTail.next;
                    prevTail.next = curr;
                    // IMPORTANT: do NOT move prev here
                } else {
                    // already right after prevTail; advance prev
                    prev = curr;
                }
                prevTail = curr;
            } else {
                // >= x: just advance prev
                prev = curr;
            }
            curr = then;
        }
        return dummy.next;
    }
}
