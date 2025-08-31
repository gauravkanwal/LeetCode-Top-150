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
 */

 //Recursive:
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        return (root1.val==root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left) );
    }
}

//Iterative: using queue
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            TreeNode root1=q.poll();
            TreeNode root2=q.poll();
            
            if(root1==null && root2==null){
                continue;
            }
            if(root1==null || root2==null){
                return  false;
            }
            if(root1.val!=root2.val){
                return false;
            }

            q.offer(root1.left);
            q.offer(root2.right);

            q.offer(root1.right);
            q.offer(root2.left);
        }
        return true;
    }
}