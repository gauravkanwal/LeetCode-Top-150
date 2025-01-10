package Solutions;

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int res=0,currMaxProfit=0;

        //we will traverse from 1st index :
        for(int i=1;i<n;i++)
        {
            currMaxProfit=Math.max(0,currMaxProfit+prices[i]-prices[i-1]);
            res=Math.max(currMaxProfit,res);
        }
        return res;
    }
}
