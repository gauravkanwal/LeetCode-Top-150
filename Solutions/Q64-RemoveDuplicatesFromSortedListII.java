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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-101);
        ListNode curr=head;
        ListNode prev=dummy;
        while(curr!=null){
            ListNode then=curr.next;
            if(then!=null && curr.val==then.val){
                while(curr!=null && curr.val==then.val){
                    curr=curr.next;
                }
            }else{
                prev.next=curr;
                prev=curr;
                curr=curr.next;
                prev.next=null;
            }
        }
        return dummy.next;
    }

}