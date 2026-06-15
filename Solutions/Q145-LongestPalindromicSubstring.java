import java.util.*;

//Memoization
class Solution {
    public String longestPalindrome(String s) {
        int l=0,r=0;
        int[][]dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(rec(s,i,j,dp) && j-i>r-l){
                    l=i;
                    r=j;
                }
            }
        }
        return s.substring(l,r+1);
    }
    private boolean rec(String s, int l, int r, int[][] dp){
        if(l>=r) return true;
        if(dp[l][r]!=-1) return dp[l][r]==1;
        dp[l][r]=s.charAt(l)==s.charAt(r) && rec(s,l+1,r-1,dp)?1:0;
        return dp[l][r]==1;
    }
}

//Tabultaion
class Solution2 {
    public String longestPalindrome(String s) {
        int l=0,r=0;
        boolean[][]dp=new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++) dp[i][i]=true;

        for(int len=2;len<=s.length();len++){
            for(int i=0;i+len-1<s.length();i++){
                int j=i+len-1;
                if(j==i+1) dp[i][j]=s.charAt(i)==s.charAt(j);
                else dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];

                if(dp[i][j]){
                    l=i;
                    r=j;
                } 
            }
        }
        return s.substring(l,r+1);
    }

}

//Non-Dp [Center Expansion]
class Solution3 {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>0 && r<n-1 && s.charAt(l-1)==s.charAt(r+1)){
                l--;
                r++;
            }
            if(r-l+1>res.length())res=s.substring(l,r+1);
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                int l=i,r=i+1;
                while(l>0 && r<n-1 && s.charAt(l-1)==s.charAt(r+1)){
                    l--;
                    r++;
                }
                if(r-l+1>res.length())res=s.substring(l,r+1);
            }
        }

        return res;
    }
}