package Solutions;


// My first Approach:
// class Solution {
//     public int maxProfit(int[] prices) {
//         int currProfit=0,maxProfit=0;
//         int n=prices.length;
//         for (int i=1;i<n;i++)
//         {
//             if(currProfit<=currProfit+prices[i]-prices[i-1])
//             {
//                 currProfit+=prices[i]-prices[i-1];
//             }
//             else
//             {
//                 maxProfit+=currProfit;
//                 currProfit=0;
//             }
//         }
//         maxProfit+=currProfit;
//         return maxProfit;
//     }
// }


// More Simpler approach:
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = prices[0];
        int len = prices.length;
        for(int i = 1;i<len; i++){
            if(start < prices[i]) maxProfit += prices[i] - start;
            start = prices[i];
        }
        return maxProfit;
    }
}