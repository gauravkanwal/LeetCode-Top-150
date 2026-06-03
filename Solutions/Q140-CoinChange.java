import java.util.*;
//Memoization:
class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp=new int[amount+1];
        Arrays.fill(dp,-2);
        Arrays.sort(coins);
        return rec(coins,amount,dp);
    }
    private int rec(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(dp[amount]!=-2) return dp[amount];
        int min=Integer.MAX_VALUE;
        for(int a:coins){
            if(a==amount){
                min=1;
                break;
            }
            else if(a<amount){
                int sol=rec(coins,amount-a,dp);
                if(sol!=-1){
                    min=Math.min(min,sol+1);
                }
            }
            else break;
        }
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
    }
}

//Tabulation:
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int [] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int c:coins){
                if(c>i) break;
                dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

}