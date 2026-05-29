//Approach 1 [Memoization]:
class Solution1 {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        return helper(n,dp);

    }

    private int helper(int n, int[] dp){
        if(dp[n]!=0) return dp[n];
        int curr=helper(n-1, dp)+helper(n-2, dp);
        dp[n]=curr;
        return curr;
    }

}

//Approach 2 [Tabulation]:
class Solution2 {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}

//Approach 3 [Optimal]:
class Solution3 {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int prev2=1, prev=2;
        for(int i=3;i<=n;i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

}