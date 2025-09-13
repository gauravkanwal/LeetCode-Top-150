class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }

    int sum(TreeNode root,int number){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return number*10+root.val;
        }
        return sum(root.left,number*10+root.val)+sum(root.right,number*10+root.val);
    }
}