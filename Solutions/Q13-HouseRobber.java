
//Memoization:
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)dp[i]=-1;
        return rec(nums,0,dp);
    }

    int rec(int[] nums, int idx, int[] dp){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        dp[idx]=Math.max(nums[idx]+rec(nums,idx+2,dp),rec(nums,idx+1,dp));
        return dp[idx];
    }
}

//Tabulation:
class Solution2 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=nums[n-1];
        dp[n-2]=Math.max(nums[n-2],nums[n-1]);
        for(int i=n-3;i>=0;i--){
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }
}

//Space Optimization:
class Solution3 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int next2=nums[n-1], next=Math.max(nums[n-2],nums[n-1]);
        for(int i=n-3;i>=0;i--){
            int temp=next;
            next=Math.max(nums[i]+next2,next);
            next2=temp;
        }
        return next;
    }
}

