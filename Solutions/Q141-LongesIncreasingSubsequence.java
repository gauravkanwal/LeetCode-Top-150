import java.util.*;
//Memoization:
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int max=1;
        for(int i=0;i<nums.length;i++)max=Math.max(max,rec(nums,dp,i));
        return max;
    }

    private int rec(int[] nums, int[] dp, int idx){
        if(dp[idx]!=-1) return dp[idx];
        int n=nums.length;
        if(idx==n-1) return 1;
        int count=1;
        for(int i=idx+1;i<n;i++){
            if(nums[i]>nums[idx]){
                count=Math.max(count,rec(nums,dp,i)+1);
            }
        }
        dp[idx]=count;
        return count;
    }
}

//Tabulation:
class Solution2 {

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=1;
        for(int i=0;i<nums.length;i++)max=Math.max(max,dp[i]);
        return max;
    }
}