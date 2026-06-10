import java.util.*;
//Memoization:
class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp=new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return rec(grid,0,0,dp);
    }
    private int rec(int[][] grid, int i, int j, int[][] dp){
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==grid.length-1 && j==grid[0].length-1) return dp[i][j]=grid[i][j];
        return dp[i][j]=grid[i][j]+Math.min(rec(grid,i+1,j,dp),rec(grid,i,j+1,dp));
    }
}

//Tabulation:
class Solution2 {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][]dp=new int[m][n];
        dp[m-1][n-1]=grid[m-1][n-1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                int res=Integer.MAX_VALUE;
                if(i<m-1)res=dp[i+1][j];
                if(j<n-1) res=Math.min(res,dp[i][j+1]);
                dp[i][j]=grid[i][j]+res;
            }
        }
        return dp[0][0];
    }

}

//Space Optiization:
class Solution3 {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[]prevRow=new int[n];
        prevRow[n-1]=grid[m-1][n-1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                int res=Integer.MAX_VALUE;
                if(i<m-1)res=prevRow[j];
                if(j<n-1) res=Math.min(res,prevRow[j+1]);
                prevRow[j]=grid[i][j]+res;
            }
        }
        return prevRow[0];
    }

}