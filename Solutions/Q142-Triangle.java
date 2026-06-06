import java.util.*;

//Memoization:
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][];
        for(int i=0;i<m;i++){
            dp[i]=new int[triangle.get(i).size()];
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return rec(triangle,dp,0,0);
    }

    private int rec(List<List<Integer>> triangle, int[][] dp, int row, int idx){
        if(row>=dp.length) return 0;
        if(dp[row][idx]!=Integer.MAX_VALUE) return dp[row][idx];
        int min=Math.min(rec(triangle,dp,row+1,idx),rec(triangle,dp,row+1,idx+1));
        return dp[row][idx]=triangle.get(row).get(idx)+min;
    }
}

//Tabulation:
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][];
        for(int i=0;i<m;i++){
            dp[i]=new int[triangle.get(i).size()];
        }

        for(int i=0;i<dp[m-1].length;i++) dp[m-1][i]=triangle.get(m-1).get(i);
        
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<dp[i].length;j++){
                int min=Math.min(dp[i+1][j],dp[i+1][j+1]);
                dp[i][j]=min+triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}

//Space Optimization:
class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[] prev=new int[m];

        for(int i=0;i<triangle.get(m-1).size();i++) prev[i]=triangle.get(m-1).get(i);
        
        for(int i=m-2;i>=0;i--){
            int[] temp=new int[triangle.get(i).size()];
            for(int j=0;j<triangle.get(i).size();j++){
                int min=Math.min(prev[j],prev[j+1]);
                temp[j]=min+triangle.get(i).get(j);
            }
            prev=temp;
        }

        return prev[0];
    }
}