/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 [9,20]
 [4,5,15,7]
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> dq= new LinkedList<>();
        dq.addLast(root);
        boolean fromLeft=false;
        while(!dq.isEmpty()){
            fromLeft=!fromLeft;
            int size=dq.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(fromLeft){
                    TreeNode node=dq.removeFirst();
                    temp.add(node.val);
                    if(node.left!=null)dq.addLast(node.left);
                    if(node.right!=null)dq.addLast(node.right);
                }
                else{
                    TreeNode node=dq.removeLast();
                    temp.add(node.val);
                    if(node.right!=null)dq.addFirst(node.right);
                    if(node.left!=null)dq.addFirst(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }
}