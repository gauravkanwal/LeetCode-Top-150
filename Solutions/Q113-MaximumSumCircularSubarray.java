class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0],minSum=nums[0], total=nums[0],prevSum=nums[0],prevMinSum=nums[0];
        
        for(int i=1;i<nums.length;i++){
            prevSum=Math.max(prevSum+nums[i],nums[i]);
            maxSum=Math.max(maxSum,prevSum);

            prevMinSum=Math.min(prevMinSum+nums[i],nums[i]);
            minSum=Math.min(prevMinSum,minSum);

            total+=nums[i];
        }

        return maxSum>0?Math.max(maxSum,total-minSum):maxSum;
    }
}
