class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp1=new int[n];
        int min=prices[0];
        for(int i=1;i<n;i++){
            dp1[i]=Math.max(dp1[i-1],prices[i]-min);
            min=Math.min(min,prices[i]);
        }   

        int dp2[]=new int[n];
        int max=prices[n-1];
        int res=0;
        for(int i=n-2;i>=0;i--){
            dp2[i]=Math.max(dp2[i+1],max-prices[i]);
            max=Math.max(max,prices[i]);
            res=Math.max(res,dp1[i]+dp2[i]);
        }
        res=Math.max(res,dp1[n-1]);
        return res;
    }
}
