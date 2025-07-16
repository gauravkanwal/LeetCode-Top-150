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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode ahead=dummy,behind=dummy;
        while(n!=0){
            ahead=ahead.next;
            n--;
        }
        while(ahead.next!=null){
            ahead=ahead.next;
            behind=behind.next;
        }
        behind.next=behind.next.next;
        return dummy.next;
    }
}