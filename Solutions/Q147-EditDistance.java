//Memoization:
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return rec(word1,word2,0,0,dp);
    }

    private int rec(String word1, String word2, int i, int j, int[][] dp){
        int m=word1.length(), n=word2.length();
        if(i==m) return n-j;
        if(j==n) return m-i;
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=rec(word1, word2, i+1, j+1, dp);
        }

        return dp[i][j]=Math.min(rec(word1,word2,i,j+1,dp), Math.min(rec(word1,word2, i+1, j, dp),rec(word1,word2,i+1,j+1,dp) ))+1;
    }
}

//Tabulation:
class Solution2 {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++)dp[i][n]=m-i;
        for(int j=0;j<=n;j++)dp[m][j]=n-j;
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j))
                    dp[i][j]=dp[i+1][j+1];
                else dp[i][j]=1+Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]));    
            }
        }

        return dp[0][0];
    }
}
