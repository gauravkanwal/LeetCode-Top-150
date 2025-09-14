
class Solution {
    int maxSum=-1001;
    public int maxPathSum(TreeNode root) {
        maxSumHelper(root);
        return maxSum;
    }
    
    private int maxSumHelper(TreeNode root){
        if(root==null){
            return 0;
        }

        int num=root.val;
        int leftMax=Math.max(maxSumHelper(root.left),0);
        int rightMax=Math.max(maxSumHelper(root.right),0);  
        maxSum=Math.max(maxSum,leftMax+rightMax+num);

        return num+Math.max(leftMax,rightMax);
    }
}