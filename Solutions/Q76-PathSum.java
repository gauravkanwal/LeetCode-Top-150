class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        if(root.val==targetSum && root.left==null && root.right==null) return true;
        if(hasPathSum(root.left,targetSum-root.val))return true;
        if(hasPathSum(root.right,targetSum-root.val)) return true;
        return false;
    }
}