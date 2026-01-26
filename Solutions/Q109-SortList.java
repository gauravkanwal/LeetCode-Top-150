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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head,fast=head;
        ListNode p=slow;
        while(fast!=null && fast.next!=null){
            p=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        p.next=null;
        ListNode list1=sortList(head);
        ListNode list2=sortList(slow);

        return merge(list1,list2);
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode prev=new ListNode(0),temp=prev;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                prev.next=list1;
                list1=list1.next;
            }else{
                prev.next=list2;
                list2=list2.next;
            }
            prev=prev.next;
        }

        prev.next=list1!=null?list1:list2;
        return temp.next;
    }
}