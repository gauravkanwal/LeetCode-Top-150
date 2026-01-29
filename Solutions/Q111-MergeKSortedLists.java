public /**
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
       return merge(lists,0,lists.length-1);
   }

   private ListNode merge(ListNode[] lists,int start,int end){
       if(lists.length==0) return null;
       if(start==end)return lists[start];
       int mid=(start+end)/2;
       ListNode left=merge(lists,start,mid);
       ListNode right=merge(lists,mid+1,end);
       return mergeTwoSortedLists(left,right);
   }

   public ListNode mergeTwoSortedLists(ListNode head1,ListNode head2){
       ListNode prev=new ListNode(0),temp=prev;
       while(head1!=null && head2!=null){
           if(head1.val<head2.val){
               prev.next=head1;
               head1=head1.next;
           }else{
               prev.next=head2;
               head2=head2.next;
           }
           prev=prev.next;
       }

       if(head1!=null) prev.next=head1;
       else prev.next=head2;
       return temp.next;
   }
} {
    
}
