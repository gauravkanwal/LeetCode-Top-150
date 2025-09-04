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
    private int postIdx;
    private HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx=postorder.length-1;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder,int inStart,int inEnd){
        if(inStart>inEnd)return null;

        int rootVal=postorder[postIdx];
        postIdx--;
        TreeNode root=new TreeNode(rootVal);
        int inRootIdx=map.get(rootVal);

        root.right=helper(postorder,inRootIdx+1,inEnd);
        root.left=helper(postorder,inStart,inRootIdx-1);
        return root;
    }
}