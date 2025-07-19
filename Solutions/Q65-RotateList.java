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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        ListNode tail=head;
        int length=0;

        //find length and tail of the list
        while(temp!=null){
            if(temp.next==null) tail=temp;
            temp=temp.next;
            length++;
        }
        if(length==0) return head;

        //make the list circular
        tail.next=head;
        k%=length;//reduce the number of rotaions needed by removing extra rotations

        //after rotating k times to the right the new tail of the list should be length-k times ahead
        for(int i=0;i<length-k;i++){
            tail=tail.next;
        }

        //break the circular property and set head=tail.next and tail.next to null
        head=tail.next;
        tail.next=null;

        return head;

    }
}