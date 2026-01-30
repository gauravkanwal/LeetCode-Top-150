class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int prevSum=nums[0];
        for(int i=1;i<nums.length;i++){
            int sum=Math.max(nums[i],prevSum+nums[i]);
            prevSum=sum;
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}