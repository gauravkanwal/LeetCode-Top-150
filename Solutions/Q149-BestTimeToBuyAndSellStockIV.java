//Memoization 3D DP
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][]dp=new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++)
            for(int j=0;j<=k;j++)
                Arrays.fill(dp[i][j],-1);
        return rec(0,k,1,dp,prices);            
    }

    private int rec(int idx, int k, int canBuy, int[][][]dp, int[]prices){
        if(idx==prices.length || k==0) return 0;
        if(dp[idx][k][canBuy]!=-1) return dp[idx][k][canBuy];
        if(canBuy==1){
            return dp[idx][k][canBuy]=Math.max(
                rec(idx+1,k,0,dp,prices)-prices[idx],
                rec(idx+1,k,1,dp,prices)
            );
        }
        return dp[idx][k][canBuy]=Math.max(
            rec(idx+1,k-1,1,dp,prices)+prices[idx],
            rec(idx+1,k,0,dp,prices)
        );
    }
}

//Tabulation 3D DP:
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n+1][k+1][2];
        
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=k;j++){
                dp[i][j][1]=Math.max(
                    dp[i+1][j][0]-prices[i],
                    dp[i+1][j][1]
                );
                
                dp[i][j][0]=Math.max(
                    dp[i+1][j-1][1]+prices[i],
                    dp[i+1][j][0]
                );
            }
        }

        return dp[0][k][1];
                   
    }

    //Space optimization:
    class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][]next=new int[k+1][2];
        
        for(int i=n-1;i>=0;i--){
            int[][] curr=new int[k+1][2];
            for(int j=1;j<=k;j++){
                curr[j][1]=Math.max(
                    next[j][0]-prices[i],
                    next[j][1]
                );
                
                curr[j][0]=Math.max(
                    next[j-1][1]+prices[i],
                    next[j][0]
                );
            }
            next=curr;
        }

        return next[k][1];
                   
    }

}
