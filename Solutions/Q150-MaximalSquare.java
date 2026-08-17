//Memoization -> TC:O(m*n) & SC:O(m*n)+O(m+n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int res=0;
        int m=matrix.length, n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int [] d:dp)Arrays.fill(d,-1);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) res=Math.max(res,rec(matrix,i,j,dp));
        return res*res;
    }
    private int rec(char[][] matrix, int i, int j, int[][] dp){
        int m=matrix.length, n=matrix[0].length;
        if(i==m || j==n) return 0;
        if(matrix[i][j]=='0') return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=Math.min(
            rec(matrix,i+1,j+1,dp),
            Math.min(
                rec(matrix,i+1,j,dp),
                rec(matrix,i,j+1,dp)
            )
        )+1;
    }
}

//Tabulation-> TC:O(m*n) & SC:O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int res=0;
        int m=matrix.length, n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=m-1;i>=0;i--)
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]!='0') dp[i][j]=1+Math.min(
                    dp[i+1][j+1],
                    Math.min(
                        dp[i][j+1],
                        dp[i+1][j]
                    )
                );
                res=Math.max(res,dp[i][j]);
            } 
        return res*res;
    }

}

//Space Optimzation-> TC:O(m*n) & SC:O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int res=0;
        int m=matrix.length, n=matrix[0].length;
        int[] dp=new int[n+1];
        for(int i=m-1;i>=0;i--)
        {    int[] next=new int[n+1];
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]!='0') next[j]=1+Math.min(
                    dp[j+1],
                    Math.min(
                        next[j+1],
                        dp[j]
                    )
                );
                res=Math.max(res,next[j]);
            }
            dp=next;
        }     
        return res*res;
    }

}
