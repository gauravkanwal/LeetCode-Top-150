class Solution {
    TreeNode currLast;
    public void flatten(TreeNode root) {
        linked(root);
    }
    private TreeNode linked(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        TreeNode leftTail=linked(root.left);
        TreeNode rightTail=linked(root.right);
        if(leftTail!=null){    
            leftTail.right=root.right;
            root.right=root.left;
            root.left=null;
        }    
        return rightTail!=null?rightTail:leftTail;
    }
}