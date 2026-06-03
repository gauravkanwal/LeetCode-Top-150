import java.util.*;
//Memoization:
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++)dp[i]=-1;
        for(String st:wordDict)set.add(st);
        return rec(s,0,set,dp);
    }
    private boolean rec(String s,int idx, HashSet<String> set,int[]dp){
        int n=s.length();
        if(idx>=n) return true;
        if(dp[idx]!=-1) return dp[idx]==0?false:true;

        for(int i=idx;i<n;i++){
            String substr=s.substring(idx,i+1);
            if(set.contains(substr)){
                if(rec(s,i+1,set,dp)){
                    dp[idx]=1;    
                    return true;
                }
            }
        }
        dp[idx]=0;
        return false;
    }
}

//Tabulation:
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[] dp=new int[s.length()+1];
        for(String st:wordDict)set.add(st);

        int n=s.length();
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                String substr=s.substring(i,j+1);
                if(set.contains(substr) && dp[j+1]==1)
                {
                    dp[i]=1;
                    break;
                }
            }  
        }
        return dp[0]==1;
    }

}