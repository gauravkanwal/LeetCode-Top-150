public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupTail = dummy;

        while (true) {
            // Step 1: Check if k nodes exist from current node
            ListNode kth = getKthNode(prevGroupTail, k);
            if (kth == null) break;

            ListNode groupStart = prevGroupTail.next;
            ListNode groupNext = kth.next;

            // Step 2: Reverse the k nodes
            ListNode prev = groupNext;
            ListNode curr = groupStart;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Connect reversed group to previous part
            prevGroupTail.next = kth;
            prevGroupTail = groupStart;
        }

        return dummy.next;
    }

    // Helper to get the kth node from a starting point
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
 {
    
}
