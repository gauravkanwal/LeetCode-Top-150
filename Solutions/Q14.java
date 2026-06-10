import java.util.*;

//Memoization:
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return rec(obstacleGrid,dp,0,0);
    }

    private int rec(int[][]grid,int[][] dp, int i, int j){
        int m=grid.length,n=grid[0].length;
        if(i>=m || j>=n) return 0;
        if(grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return dp[i][j]=1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=rec(grid,dp,i+1,j)+rec(grid,dp,i,j+1);
    }
}

//Tabulation:
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                if(obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                    continue;
                }
                int res=0;
                if(i<m-1)res+=dp[i+1][j];
                if(j<n-1)res+=dp[i][j+1];
                dp[i][j]=res;
            }
        }
        return dp[0][0];

    }

}

//Space Optimization:
class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[] dp=new int[n];
        dp[n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                if(obstacleGrid[i][j]==1) {
                    dp[j]=0;
                    continue;
                }
                int res=0;
                if(i<m-1)res+=dp[j];
                if(j<n-1)res+=dp[j+1];
                dp[j]=res;
            }
        }
        return dp[0];

    }

}