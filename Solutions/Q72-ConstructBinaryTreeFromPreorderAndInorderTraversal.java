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
    private HashMap<Integer,Integer> map;
    private int preorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        
        preorderIdx=0;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);

    }

    private TreeNode helper(int[] preorder,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        int rootVal=preorder[preorderIdx];
        TreeNode root=new TreeNode(rootVal);
        preorderIdx++;

        int inRootIdx=map.get(rootVal);

        root.left=(helper(preorder,inStart,inRootIdx-1));
        root.right=(helper(preorder,inRootIdx+1,inEnd));
        return root;
    }
}