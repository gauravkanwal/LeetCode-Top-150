import java.util.*;

//Memoization
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++) Arrays.fill(dp[i],-1);
        return rec(s1,s2,s3,0,0,dp)==1;
    }

    private int rec(String s1, String s2, String s3, int i, int j,int[][]dp){
        int k=i+j;
        int m=s1.length(),n=s2.length(),N=s3.length();
        if(i==m && j==n && k==N) return 1;
        if(k==N) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(i<m && s1.charAt(i)==s3.charAt(k) && rec(s1,s2,s3,i+1,j,dp)==1) return dp[i][j]=1;
        if(j<n && s2.charAt(j)==s3.charAt(k) && rec(s1,s2,s3,i,j+1,dp)==1) return dp[i][j]=1;
        return dp[i][j]=0;
    }
}

//Tabulation4
class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),N=s3.length();
        if(N!=m+n) return false;
        boolean [][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[m][n]=true;
        
        for(int i=m-1;i>=0;i--){
            dp[i][n]=dp[i+1][n] && s1.charAt(i)==s3.charAt(i+n);
        }
        
        for(int j=n-1;j>=0;j--){
            dp[m][j]=dp[m][j+1] && s2.charAt(j)==s3.charAt(j+m);
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int k=i+j;
                char c1=s1.charAt(i),c2=s2.charAt(j),c3=s3.charAt(k);
                if(c1==c3 && dp[i+1][j]) dp[i][j]=true;
                else if(c2==c3 && dp[i][j+1]) dp[i][j]=true;
            }
        }

        return dp[0][0];
    }
}