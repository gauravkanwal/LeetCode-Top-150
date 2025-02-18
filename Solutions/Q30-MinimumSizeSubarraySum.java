package Solutions;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0;
        int windowSum=0;
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        while(right<n && left<n)
        {
            windowSum+=nums[right];
            while(windowSum>=target)
            {
                ans=Math.min(ans,right-left+1);
                windowSum-=nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}