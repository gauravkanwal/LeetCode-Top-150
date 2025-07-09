/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map=new HashMap<>();

        Node ans=new Node(-1);
        Node temp=head;
        Node temp2=ans;

        //copying the original list to the new linked list
        while(temp!=null){
            Node newNode=new Node(temp.val);
            map.put(temp,newNode);
            temp2.next=newNode;
            temp2=temp2.next;
            temp=temp.next;
        }

        //connecting the random pointers
        temp=head;
        temp2=ans.next;
        while(temp!=null){
            temp2.random=map.get(temp.random);
            temp=temp.next;
            temp2=temp2.next;
        }

        return ans.next;
    }
}