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
class Solution {
    int h=0;
    public int countNodes(TreeNode root) {
        int lh=leftHeight(root);
        int rh=rightHeight(root);

        if(lh==rh){
            return (int)Math.pow(2,lh)-1;
        }

        return countNodes(root.left)+countNodes(root.right)+1;
        
    }

    private int leftHeight(TreeNode root){
        if (root==null )return 0;
        int count=0;
        while(root!=null){
            root=root.left;
            count++;
        }
        return count;
    }
    
    private int rightHeight(TreeNode root){
        if (root==null) return 0;
        int count=0;
        while(root!=null){
            root=root.right;
            count++;
        }
        return count;
    }
}