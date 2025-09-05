/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//O(n) space approach (Using Queue):

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            Node pre=null;
            for(int i=0;i<size;i++){
                Node popped = q.poll();
                if(pre!=null){
                    pre.next=popped;
                }
                pre=popped;
                if(popped.left!=null)q.offer(popped.left);
                if(popped.right!=null)q.offer(popped.right);
            }
        }
        return root;
    }
}