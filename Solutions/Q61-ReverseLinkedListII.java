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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        
        for(int i=0;i<left-1;i++){
            prev=prev.next;
        }
        ListNode leftNode=prev.next;
        ListNode curr=leftNode;
        ListNode then=curr.next;

        for(int i=1;i<=right-left;i++){
            ListNode temp=then.next;
            then.next=curr;
            curr=then;
            then=temp;
        }

        prev.next=curr;
        leftNode.next=then;

        return dummy.next;

    }
}